package functions;

import java.io.Serializable;
import java.util.Arrays;


public class ArrayTabulatedFunction implements TabulatedFunction, Serializable, Cloneable{

    private FunctionPoint[] arrayPoint;


    public ArrayTabulatedFunction(FunctionPoint[] array) { //конструктор, получающий сразу все точки функции в виде массива объектов

        if (array.length < 2) {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].x >= array[i].x) {
                throw new IllegalArgumentException();
            }
        }
        arrayPoint = new FunctionPoint[array.length];
        System.arraycopy(array, 0, arrayPoint, 0, array.length);
    }

    public ArrayTabulatedFunction(double leftX, double rightX, int pointsCount) throws IllegalArgumentException {
        if (leftX >= rightX || pointsCount < 2) throw new IllegalArgumentException("error");
        else {
            double k = (rightX - leftX) / (pointsCount - 1);
            arrayPoint = new FunctionPoint[pointsCount];
            for (int i = 0; i < pointsCount; i++) {
                arrayPoint[i] = new FunctionPoint(leftX, 0);
                leftX = leftX + k;
            }
        }

    }

    public ArrayTabulatedFunction(double leftX, double rightX, double[] value) {
        if (leftX >= rightX || value.length < 2) throw new IllegalArgumentException("error");
        else {
            double k = (rightX - leftX) / (value.length - 1);
            arrayPoint = new FunctionPoint[value.length];
            for (int i = 0; i < value.length; i++) {
                arrayPoint[i] = new FunctionPoint(leftX, value[i]);
                leftX = leftX + k;
            }
        }
    }

    public FunctionPoint getPoint(int index) {
        if (index >= 0 && index < getPointsCount()) {
            return new FunctionPoint(this.arrayPoint[index]);
        } else {
            return null;
        }
    }

    public double getLeftDomainBorder() {
        return this.arrayPoint[0].getX();
    }

    public double getRightDomainBorder() {
        return arrayPoint[arrayPoint.length - 1].getX();
    }

    public double getFunctionValue(double x) {

        if (!(x < getLeftDomainBorder() || x > getRightDomainBorder())) {

            int last = this.getPointsCount();
            int first = 0;
            int mid = first + (last - first) / 2;
            if (arrayPoint.length == 0) {
                return Double.NaN;
            }
            if (arrayPoint[0].getX() > x) {
                return Double.NaN;
            }
            if (arrayPoint[this.getPointsCount() - 1].getX() < x || arrayPoint[this.getPointsCount() - 1].getX()!=x) {
                return Double.NaN;
            }
            while (first < last) {
                if (x <= arrayPoint[mid].getX()) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
                mid = first + (last - first) / 2;
            }
            if (arrayPoint[last].getX() == x) {
                return arrayPoint[last].getY();
            } else {
                double k = (arrayPoint[last].getY() - arrayPoint[last - 1].getY()) / (arrayPoint[last].getX() - arrayPoint[last - 1].getX());
                double b = arrayPoint[last].getY() - k * arrayPoint[last].getX();
                return k * x + b;
            }
        } else {
            return Double.NaN;
        }
    }

    public int getPointsCount() {
        return arrayPoint.length;
    }


    public void setPoint(int index, FunctionPoint point) throws FunctionPointIndexOutOfBoundsException, InappropriateFunctionPointException {
        if (index >= 0 && index < getPointsCount()) {
            if (arrayPoint[index].getX() < arrayPoint[index + 1].getX() && arrayPoint[index].getX() > arrayPoint[index - 1].getX()) {
                arrayPoint[index] = point;
            } else throw new InappropriateFunctionPointException(" error x");
        } else throw new FunctionPointIndexOutOfBoundsException(" error index");
    }

    public double getPointX(int index) throws FunctionPointIndexOutOfBoundsException {
        if (index >= 0 && index < getPointsCount()) {
            return this.arrayPoint[index].getX();
        } else throw new FunctionPointIndexOutOfBoundsException(" error index ");

    }


    public void setPointX(int index, double x) throws FunctionPointIndexOutOfBoundsException, InappropriateFunctionPointException {
        if (index >= 0 && index < getPointsCount()) {
            if (x < arrayPoint[index + 1].getX() && x > arrayPoint[index - 1].getX()) {
                arrayPoint[index].setX(x);
            } else throw new InappropriateFunctionPointException(" error x");
        } else throw new FunctionPointIndexOutOfBoundsException(" error index");
    }


    public double getPointY(int index) throws FunctionPointIndexOutOfBoundsException {
        if (index >= 0 && index < getPointsCount()) {
            return this.arrayPoint[index].getY();
        } else throw new FunctionPointIndexOutOfBoundsException(" error index");

    }

    public void setPointY(int index, double y) throws FunctionPointIndexOutOfBoundsException {
        if (index >= 0 && index < getPointsCount()) {
            if (y < arrayPoint[index + 1].getY() && y > arrayPoint[index - 1].getY()) {
                arrayPoint[index].setY(y);
            }
        } else throw new FunctionPointIndexOutOfBoundsException(" error index");

    }

    public void deletePoint(int index) throws FunctionPointIndexOutOfBoundsException, IllegalStateException {

        int a = getPointsCount();

        if (a < 3) throw new IllegalStateException();
        else if (index >= 0 && index < a) {
            System.arraycopy(this.arrayPoint, index, this.arrayPoint, index - 1, this.getPointsCount() - index);
            arrayPoint[a - 1] = new FunctionPoint();
        } else throw new FunctionPointIndexOutOfBoundsException(" error index");

    }

    public void addPoint(FunctionPoint point) throws InappropriateFunctionPointException {

        int a = getPointsCount();
        int last = this.getPointsCount();

        for (int i = 0; i < arrayPoint.length; i++) {
            if (arrayPoint[i].x == point.x) throw new InappropriateFunctionPointException(" the same");
        }

        if (a < arrayPoint.length) {
            System.arraycopy(this.arrayPoint, last, this.arrayPoint, last + 1, this.getPointsCount() - last);
            this.arrayPoint[last] = point;
            ++a;
        } else {
            int newCount = a + 1;
            FunctionPoint pointsNew[] = new FunctionPoint[newCount];
            System.arraycopy(this.arrayPoint, 0, pointsNew, 0, a);
            this.arrayPoint = pointsNew;
            this.arrayPoint[last] = point;
            ++a;

        }
    }

    public String toString() {

        StringBuilder buffer = new StringBuilder("{");
        for (int i = 0; i < this.getPointsCount(); i++) {
            buffer.append(this.arrayPoint[i].toString()).append(", ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("}");
        return buffer.toString();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof TabulatedFunction) {
            if (o instanceof ArrayTabulatedFunction) {
                ArrayTabulatedFunction func = (ArrayTabulatedFunction) o;
                if (func.getPointsCount() != this.getPointsCount()) return false;
                for (int i = 0; i < getPointsCount(); i++) {
                    if (func.arrayPoint[i].x != this.arrayPoint[i].x) return false;
                }
                for (int i = 0; i < getPointsCount(); i++) {
                    if (func.arrayPoint[i].y != this.arrayPoint[i].y) return false;
                }
                return true;
            } else {

                TabulatedFunction func = (TabulatedFunction) o;
                if (func.getPointsCount() != this.getPointsCount()) {
                    return false;
                }
                for (int i = 0; i < this.getPointsCount(); i++) {
                    if (!(this.getPoint(i).equals(func.getPoint(i)))) {
                        return false;
                    }
                }
                return true;
            }
        } else return false;

    }

    public int hashCode(){
            int hash = 5;
            hash = 31 * hash + Arrays.deepHashCode(this.arrayPoint);
            hash = 31 * hash + this.getPointsCount();
            return hash;
            }

    public Object clone()  throws CloneNotSupportedException  {
        FunctionPoint points[] = new FunctionPoint[getPointsCount()];
        for (int i = 0; i < this.getPointsCount(); i++) {
            points[i] = (FunctionPoint) this.arrayPoint[i].clone();

        }
        return new ArrayTabulatedFunction(points);
    }


}


