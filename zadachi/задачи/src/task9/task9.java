package task9;

import java.lang.reflect.Method;

/**
 * Created by ivan1 on 05.01.2017.
 */
public class task9 {
    public static String[] getMethodsNames(Object obj){
        Class cl = obj.getClass();                                      //определяем класс объекта
        Method[] mtds = cl.getMethods();                                // в массив пишем его методы
        String[] methods = new String[mtds.length];                     //во второй массив пишем имена методов
        for (int i=0; i<mtds.length; ++i){
            methods[i]=mtds[i].getName();
        }
        return methods;
    }
    public static void main(String[] args) {
        task9 st = new task9();                             //создаем объект
        String[] arr = getMethodsNames(st);                 //получаем имена методов
        for (int i=0; i< arr.length; ++i){
            System.out.println(arr[i]);                     //выводим их
        }
    }
}
