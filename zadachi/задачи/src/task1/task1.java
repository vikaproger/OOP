package task1;

import java.io.*;
import java.util.ArrayList;

public class task1 {

    /**
     *
     * Написать программу, вычисляющую среднее, а также минимальное и максимальное значения вещественных чисел,
     * переданных как параметры при запуске программы. Полученные три числа следует вывести на экран (консоль).
     * Рекомендуется писать программу, состоящую из одного класса,
     * содержащего точку входа программы. Параметры при запуске могут указываться с ошибками.
     * */

    public static boolean isDouble(String s) {               // фунция для проверки вводимых чисел
        try {
            Double.parseDouble(s);                           // если введеная строка является числом с плавающей запятой то вернем правду
        } catch (NumberFormatException e) {
            return false;                                   //иначе чтото не так и борай исключение
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));       //поток чтения с консоли
        String s = reader.readLine();                                                   //читаем строку
        ArrayList<Double> list = new ArrayList<>();                                     // создаем лист в который будем складывать числп
        String[] array1 = s.split(" ");                                          // строку по пробелам разобъем на массив строк
        for (int i=0; i< array1.length; ++i){
            if (isDouble(array1[i])) list.add(Double.parseDouble(array1[i]));           // и если ячейка массива строк - число тогда добавляем его в лист
        }
        double max = -100000000, min=100000000;                                         //установим занчения для поиска максимума и минимума
        double mid=0;                                                                   // переменная для подсчета среднего
        for (int i =0; i<list.size(); ++i) {                                            //производим поиск и расчет занчения
            if(list.get(i)<min) min=list.get(i);
            if(list.get(i)>max) max=list.get(i);
            mid+=list.get(i);
        }
        mid=mid/list.size();
        System.out.println("min = " + min);                                 //вывод значений в консоль
        System.out.println("max = " + max);
        System.out.println("mid = " + mid);
    }

}
