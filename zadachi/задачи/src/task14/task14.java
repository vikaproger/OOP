package task14;

/**
 * Created by ivan1 on 05.01.2017.
 */
public class task14 {
    //поля
    private double value;
    private static task14 instance;

    //конструктор
    private task14(){}

    //создание экземпляра
    public static task14 instance(){
        if(instance == null){
            instance=new task14();
        }
        return instance;
    }

    //методы слжение умножение и получение значения
    public void addValue(double addedValue){
        value+=addedValue;
    }

    public  void multValue(double multedValue){
        value*=multedValue;
    }

    public double getValue() {
        return value;
    }
}
