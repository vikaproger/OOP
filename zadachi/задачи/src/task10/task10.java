package task10;

public class task10<T> {
    //поле
    private T[] arr;

    //конструктор
    public task10(T[] arr) {
        this.arr = arr;
    }

    //поиск минимума
    public double min(){
        double min = Double.POSITIVE_INFINITY;          // ячейка для поичка минимума
        for (int i=0; i<arr.length;++i){
            if(Double.parseDouble(arr[i].toString())<min){
                min=Double.parseDouble(arr[i].toString());          //если нашли меньще запомним найденный элемент
            }
        }
        return min;  //вернули минимум
    }

    //поиск максимума
    public double max(){
        double max = Double.NEGATIVE_INFINITY;          //ячейка для поиска максимума
        for (int i=0; i<arr.length;++i){
            if(Double.parseDouble(arr[i].toString())>max){
                max=Double.parseDouble(arr[i].toString());      //если найдем больше запомним найденный
            }
        }
        return max;     //вернули максимум
    }

    public static void main(String[] args) {
        Integer[] array={2,3,12,3,-19,2,4,5,-76,1};          // массив чисел
        task10<Integer>task10=new task10<Integer>(array);           //создали объект
        System.out.println("min "+ task10.min()+ "\nmax " + task10.max());  //определили и вывели минимум и максимум
    }
}
