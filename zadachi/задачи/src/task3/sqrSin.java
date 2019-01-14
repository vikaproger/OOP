package task3;

public class sqrSin extends trigonometric {     //класс синуса
    @Override
    public double getFunctionValue(double x) {      //вычисляем значение
        return Math.sin(x)*Math.sin(x);
    }
}
