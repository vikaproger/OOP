package task6;

import java.io.*;

public class task6 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));           //поток для чтения с консоли
        System.out.println("Name of file");
        String name = in.readLine();                                                        // читаем имя файла
        System.out.println("Line");
        int line = Integer.parseInt(in.readLine());                                         //читаем кол-во строк
        if (line<=0) throw new IllegalArgumentException("Неверное количество строк");
        System.out.println("Column");
        int column = Integer.parseInt(in.readLine());                                       //читаем кол-во столбцов
        if (column<=0) throw new IllegalArgumentException("Неверное количество столбцов");
        System.out.println("leftBorder");
        double leftBorder = Double.parseDouble(in.readLine());                              //читаем левую границу
        System.out.println("rightBorder");
        double rightBorder = Double.parseDouble(in.readLine());                             // правую границу
        double[][] matrix = new double[line][column];                                       //создаем матрицу
        for (int i=0; i<line; ++i){
            for(int j=0; j<column; ++j){
                matrix[i][j] = Math.random()*(rightBorder-leftBorder)+leftBorder;            //заполняем
            }
        }
        try{
            DataOutputStream file = new DataOutputStream(new FileOutputStream(name));       //создаем БАЙТОВЫЙ поток для записи
            file.writeInt(line);                                                            //записываем кол-во строк
            file.writeInt(column);                                                          //столбцов
            for (int i=0; i<line; ++i){
                for (int j=0; j<column; ++j){
                    file.writeDouble(matrix[i][j]);                                         // матрицу
                }
                file.writeChar('\n');
            }
            file.close();
        } catch (NumberFormatException ex){                                     //если что то пошло не так выбросили исключение
            ex.printStackTrace();
        }
    }
}