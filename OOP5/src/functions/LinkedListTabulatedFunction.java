package functions;

import java.io.Serializable;


public class LinkedListTabulatedFunction implements TabulatedFunction, Serializable {

    private class FunctionNode{
        private FunctionPoint point= null;
        private FunctionNode prev=null, next= null;
    }


    private int length, currentIndex;
    private FunctionNode headMain = new FunctionNode(), head, tail, current;

    {
        headMain.next = headMain;
        headMain.prev = headMain;
        head = headMain;
        tail = headMain;
        current = headMain;

    }

    public LinkedListTabulatedFunction(FunctionPoint[] array) throws IllegalArgumentException {   //конструктор, получающий сразу все точки функции в виде массива объектов
        if (array.length < 2) throw new IllegalArgumentException();

        for (int i = 1; i < array.length; i++) {

            if (array[i - 1].x >= array[i].x) {

                headMain.next = headMain;
                headMain.prev = headMain;
                head = headMain;
                tail = headMain;
                current = headMain;

                throw new IllegalArgumentException();

            } else {
                current.next = new FunctionNode();
                current.next.prev = current;
                current.next.point = new FunctionPoint(array[i - 1].x, array[i - 1].y);
                current = current.next;
            }
        }
        current.next = new FunctionNode();
        current.next.prev = current;
        current.next.point = new FunctionPoint(array[array.length-1].x, array[array.length-1].y);
        current = current.next;
        length = array.length;
        head = headMain.next;
        headMain.prev = current;
        tail = current;
        tail.next = headMain;
    }

    public LinkedListTabulatedFunction  (double leftX, double rightX, int pointsCount) throws IllegalArgumentException
    {
        if (leftX>= rightX || pointsCount<2) throw new IllegalArgumentException("error");
        else {
             length=pointsCount;
             head=new FunctionNode();
             headMain.next=head;
             current=head;
             head.prev=headMain;

            current.point=new FunctionPoint(leftX,0);
            current.next=new FunctionNode();
            current.next.prev=current;
            current=current.next;
            currentIndex++;

            double k= (rightX-leftX)/(pointsCount-1);

            for(int i=1; i<length; i++){
                current.point=new FunctionPoint(current.prev.point.x+k,0);
                current.next=new FunctionNode();
                current.next.prev=current;
                current=current.next;
                currentIndex++;
            }

            tail=current.prev;
            tail.next=headMain;
            headMain.prev=tail;
        }
    }

    public LinkedListTabulatedFunction(double leftX, double rightX, double value[]) throws IllegalArgumentException  {

        if (leftX>= rightX || value.length<2) throw new IllegalArgumentException("error");
        else {
            length=value.length;
            head=new FunctionNode();
            headMain.next=head;
            current=head;
            head.prev=headMain;

            current.point=new FunctionPoint(leftX,value[0]);
            current.next=new FunctionNode();
            current.next.prev=current;
            current=current.next;
            currentIndex++;

            double k= (rightX-leftX)/(value.length-1);

            for(int i=1; i<length; i++){
                current.point=new FunctionPoint(current.prev.point.x+k,value[i]);
                current.next=new FunctionNode();
                current.next.prev=current;
                current=current.next;
                currentIndex++;
            }

            tail=current.prev;
            tail.next=headMain;


            }
    }

    public FunctionNode getNodeByIndex(int index)
    {
        //получаем элемент списка с текущим индексом

        int fromTail = length - index - 1;
        int fromHead = index;
        int fromCurrent = Math.abs(currentIndex - index);

        if (fromTail < fromHead) { //ищем от куда быстрее добраться до нужного индекса
            if (fromTail < fromCurrent) {
                current = tail;
                currentIndex = length - 1;
            }
        } else {
            if (fromHead < fromCurrent) {
                current = head;
                currentIndex = 0;
            }
        }

        if (index < currentIndex) { //нашли индекс от куда быстрее добраться, теперь выбираем вперед двигаться или назад
            while (currentIndex != index) {
                current = current.prev;
                currentIndex--;
            }
        } else {
            while (currentIndex != index) {
                current = current.next;
                currentIndex++;
            }
        }

        return current;
    }

    public FunctionNode addNodeToTail() { //добавить элемент в конец

        tail.next= new FunctionNode();
        tail.next.prev=tail;
        tail.next.next=headMain;
        tail=tail.next;
        length++;
        headMain.prev=tail;
        return tail;
    }

    public FunctionNode addNodeByIndex(int index){ // добавляем новый элемент на указанную позицию

        if (index == length) {
            return addNodeToTail();
        }
        else {
            getNodeByIndex(index);
            FunctionNode node= new FunctionNode();
            node.next=current;
            node.prev=current.prev;
            current.prev.next=node;
            current.prev=node;

            current=node;
            length++;
            return current;

        }
    }

    public FunctionNode deleteNodeByIndex(int index){ // возвращаем ссылку удаленного элемента из списка

        getNodeByIndex(index);
        FunctionNode node=current;
        current.prev.next=current.next;
        current.next.prev=current.prev;
        current=current.prev;
        --currentIndex;
        --length;

        head=headMain.next;
        tail=headMain.prev;

        return node;

    }

    public double getLeftDomainBorder() throws IllegalStateException {
        if (length == 0) throw new IllegalStateException();

        return head.point.x;

    }

    public double getRightDomainBorder() throws IllegalStateException{
        if (length == 0) throw new IllegalStateException();

        return tail.point.x;
    }

    public int getPointsCount() {
        return length;
    }



    public void setPoint (int index, FunctionPoint point) throws FunctionPointIndexOutOfBoundsException, InappropriateFunctionPointException
    {
       if (length==0)throw new IllegalStateException();
       if ( index<0 || index>= length) throw new FunctionPointIndexOutOfBoundsException( " error ");

        double leftValue = Double.MIN_VALUE;
        double rightValue = Double.MAX_VALUE;

        FunctionNode node = getNodeByIndex(index);

        if( node.prev!= null){
            leftValue=node.prev.point.x;
        }
        if( node.next!= null){
            rightValue=node.next.point.x;
        }

        if (leftValue>point.x||rightValue<point.x) throw new InappropriateFunctionPointException("error");

        node.point= new FunctionPoint(point);
    }

    public double getPointX(int index) {
        if (length == 0) throw new IllegalStateException();
        if (index < 0 || index >= length) throw new FunctionPointIndexOutOfBoundsException(" error ");

        return getNodeByIndex(index).point.x;
    }

    public void setPointX(int index, double x) throws InappropriateFunctionPointException {
        if (length == 0) throw new IllegalStateException();
        if (index < 0 || index >= length) throw new FunctionPointIndexOutOfBoundsException(" error ");


        double leftValue = Double.MIN_VALUE;
        double rightValue = Double.MAX_VALUE;

        FunctionNode node = getNodeByIndex(index);

        if (node.prev != null) {
            leftValue = node.prev.point.x;
        }
        if (node.next != null) {
            rightValue = node.next.point.x;
        }

        if (leftValue > x || rightValue < x) throw new InappropriateFunctionPointException(" error ");

        node.point.x = x;
    }

    public double getPointY(int index) {
        if (length == 0) throw new IllegalStateException();
        if (index < 0 || index >= length) throw new FunctionPointIndexOutOfBoundsException(" error ");

        return getNodeByIndex(index).point.y;
    }

    public void setPointY(int index, double y) {
        if (length == 0) throw new IllegalStateException();
        if (index < 0 || index >= length) throw new FunctionPointIndexOutOfBoundsException(" error ");

        getNodeByIndex(index).point.y = y;
    }

    public FunctionPoint getPoint(int index) {
        getNodeByIndex(index);
        return new FunctionPoint(current.point);
    }

    public double getFunctionValue(double x) {
        if (length == 0) throw new IllegalStateException();
        if (x < head.point.x || x > tail.point.x) throw new FunctionPointIndexOutOfBoundsException(" error ");

        current = head;
        currentIndex = 0;
        while (current.point.x > x) {
            current = current.next;
            currentIndex++;
        }

        if (Math.abs(current.point.x -x)< Double.MIN_VALUE) {
            return current.point.y;
        }

        return (current.next.point.y - current.point.y) / (current.next.point.y - current.point.y) * (x - current.point.x);
    }

    public void deletePoint(int index) {
        if (length < 3) throw new IllegalStateException();
        if (index < 0 || index >= length) throw new FunctionPointIndexOutOfBoundsException( " error ");

        deleteNodeByIndex(index);
    }



    public void addPoint(FunctionPoint point) throws InappropriateFunctionPointException {
        if (length != 0 && (point.x < head.point.x || point.x > tail.point.x)) throw new InappropriateFunctionPointException(" error ");

        if (length == 0) {
            head = new FunctionNode();
            head.point = new FunctionPoint(point);
            length++;
            tail = head;
            current = head;
            currentIndex = 0;
            return;
        }

        current = head;
        currentIndex = 0;
        while (current.point.x < point.x) {
            current = current.next;
            currentIndex++;
        }

        if (current.point.x == point.x) throw new InappropriateFunctionPointException( " error ");


        addNodeByIndex(currentIndex).point = point;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer("{");

        currentIndex = 0;
        current = head;

        while (current != headMain) {
            buffer.append(current.point.toString()).append(", ");
            currentIndex++;
            current = current.next;
        }

        buffer.deleteCharAt(buffer.length() - 1).deleteCharAt(buffer.length() - 1);
        buffer.append("}");
        return buffer.toString();
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof TabulatedFunction) {
            if (o instanceof LinkedListTabulatedFunction) {
                LinkedListTabulatedFunction func = (LinkedListTabulatedFunction) o;
                if (func.length != this.length) {
                    return false;
                }
                currentIndex = 0;
                this.current = this.head;
                FunctionNode funcCurrent = func.head;
                while (this.current != this.headMain) {
                    if (this.current.point.x != funcCurrent.point.x) {
                        return false;
                    }
                    if (this.current.point.y != funcCurrent.point.y) {
                        return false;
                    }
                    this.current = this.current.next;
                    funcCurrent = funcCurrent.next;
                    ++currentIndex;
                }
                return true;
            } else {
                TabulatedFunction func = (TabulatedFunction) o;
                if (func.getPointsCount() != this.length) {
                    return false;
                }
                for (int i = 0; i < this.length; i++) {
                    if (!(this.getPoint(i).equals(func.getPoint(i)))) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

     public int hashCode(){
         currentIndex = 0;
         current = head;

         int result = 0;

         while (current != headMain) {
             result += current.point.hashCode();
             currentIndex++;
             current = current.next;
         }

         return length + result;
     }


    public Object clone() throws CloneNotSupportedException {
        FunctionPoint points[] = new FunctionPoint[length];

        currentIndex = 0;
        current = head;

        while (current != headMain) {
            points[currentIndex] = current.point;
            currentIndex++;
            current = current.next;
        }

        return new LinkedListTabulatedFunction(points);

    }

}
