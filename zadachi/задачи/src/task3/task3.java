package task3;

public class task3 {
    public static void main(String[] args) {

       interface3 sum = new SumFunction(new sqrCos(), new sqrSin()); // создаем объект и сохряняем ссылку в поле интерфейсноого типа
       for (double i=0; i< 6.28; i+=0.1) System.out.println(sum.getFunctionValue(i));   //выводим значения в консоль

    }

}
