package task3;

public class sqrCos extends trigonometric {     //класс косинуса

    @Override
    public double getFunctionValue(double x) {      //значение функции
        return Math.cos(x)*Math.cos(x);
    }
}
