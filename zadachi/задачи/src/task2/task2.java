package task2;

public class task2 {
    public static void main(String[] args) {

        //проверка работы методов НЕ ОБЯЗАТЕЛЬНА ПО ТЗ
        matrix matr = new matrix(3,5);
        System.out.println(matr.getLine());
        System.out.println(matr.getColumn());
        System.out.println(matr.getItem(0,0));
        for(int i =0; i< matr.getLine(); ++i){
            for (int j=0; j<matr.getColumn();++j){
                System.out.print(matr.getMatrix()[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] matrix1 = matrix.transponirovanie(matr);
        for(int i =0; i< matrix1.length; ++i){
            for (int j=0; j< matrix1[i].length;++j){
                System.out.print(matrix1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i =0; i< matr.getLine(); ++i){
            for (int j=0; j<matr.getColumn();++j){
                System.out.print(matr.getMatrix()[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        matr.setItem(0,0, 15);

        for(int i =0; i< matr.getLine(); ++i){
            for (int j=0; j<matr.getColumn();++j){
                System.out.print(matr.getMatrix()[i][j]+" ");
            }
            System.out.println();
        }


    }
}
