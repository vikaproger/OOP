package task5;

import java.io.*;
import java.util.Arrays;

public class task5 {
    public static void main(String[] args)throws IOException {
        double[] matrix;                                                               // переменная для хранения матрицы
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));       //поток для чтения с консоли
        String nameIn = in.readLine();                                                  //читаем имя входного файла
        String nameOut = in.readLine();                                                 //читаем имя выходного файла
        try {
            ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(nameIn));      //открываем поток для чтения
            ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(nameOut)); //открываем поток для записи
            matrix = (double[])inFile.readObject();                                             //считываем матрицу
            Arrays.sort(matrix, 0, matrix.length-1);                          //сортируем ее
            outFile.writeObject(matrix);                                                        //записываекм ее в файл
            inFile.close();                                                                 //закрываем файл
            outFile.close();
        } catch (ClassNotFoundException e) {                        // если что то пошло не так выбросим исключение
            e.printStackTrace();
        }
    }
}
