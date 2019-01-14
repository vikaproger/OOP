package task2;

import java.util.Random;

public class matrix {
    /**
     *
     * Написать класс матриц, поддерживающий операцию транспонирования.
     * Должны быть описан один класс, который должен:
     •	инкапсулировать в себе массив-матрицу;
     •	иметь конструктор, параметрами которого являются размеры матрицы;
     •	реализовывать получение размеров матрицы;
     •	реализовывать получение и изменение отдельных элементов матрицы;
     •	иметь статический метод транспонирования матриц, возвращающий транспонированную матрицу.
     */

    //поля
    private int matrix[][];
    private static int line, column;

    //конструктор
    public matrix(int line, int column){
        if(line<0 || column<0) throw new IllegalArgumentException("Incorrect size");        //если размеры не верные бросаем исключение
        this.line=line;
        this.column=column;
        matrix = new int[line][column];         //создаем матрицу
        Random random = new Random();
        for(int i=0; i<line; ++i){              //заполняем
            for (int j=0; j<column; ++j){
                matrix[i][j]= random.nextInt(5);
            }
        }
    }


    //методы get set
    public int[][] getMatrix() {
        return matrix;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    //получение элемента
    public int getItem(int line, int column){
        if(line <0 || line > getLine()) throw new IllegalArgumentException("Incorrect size: check number line");        //проверка индекса
        if(column < 0 || column > getColumn()) throw new IllegalArgumentException("Incorrect size: check number column");
        return matrix[line][column];            //возвращаем элемент
    }

    //изменение элемента
    public void setItem(int line, int column, int Item){
        if(line <0 || line > getLine()) throw new IllegalArgumentException("Incorrect size: check number line");//проверка индекса
        if(column < 0 || column > getColumn()) throw new IllegalArgumentException("Incorrect size: check number column");
        matrix[line][column]=Item;              //изменяем элемент
    }

    public static int[][] transponirovanie (matrix matr){       //операция транспонирования
        int tmatrix[][] = new int[matr.getColumn()][matr.getLine()];        //создаем матрицу с транспонированныцми границами
        for (int i =0; i< tmatrix.length; ++i){
            for(int j=0; j<tmatrix[i].length; ++j){
                tmatrix[i][j]=matr.matrix[j][i];            //заполняем ее
            }
        }
        return tmatrix; //возвращаем транспонированную матрицу
    }
}
