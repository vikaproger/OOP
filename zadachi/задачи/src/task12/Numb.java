package task12;

import java.io.Serializable;
import java.util.Iterator;

public class Numb implements Iterable<Double>, Serializable{

    //поля
    private double[] array;


    //конструктор
    public Numb(int lenght){
        array = new double[lenght];
        for(int i =0; i<array.length;++i){
            array[i]=Math.random()*100;
        }
    }

    //получение длины массива
    public int getLenght(){
        return array.length;
    }

    // получение значения
    public double getValue(int index){
        if(index<0||index>array.length) throw new IllegalArgumentException("Неверно задан индекс!");
        return array[index];
    }

    //итератор
    public Iterator iterator(){
        return new Iterator<Double>(){
            int currentIndex=-1;

            //проверка наличия следующего элемента
            @Override
            public boolean hasNext() {
                return currentIndex<array.length-1;
            }

            //получение следующего элемнта
            @Override
            public Double next() {
                if(hasNext()){
                    return array[++currentIndex];
                }else throw new IllegalArgumentException();
            }

            //метод удаления
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Не поддерживается");
            }
        };
    }
}
