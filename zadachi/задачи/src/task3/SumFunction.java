package task3;

public class SumFunction extends trigonometric{            //класс описывающий сумму синуса и косинуса

    // поля
    private sqrCos cos;
    private sqrSin sin;

    // конструктор
    public SumFunction(sqrCos cos, sqrSin sin) {
        this.cos = cos;
        this.sin = sin;
    }

    // вычисляем значение функции
    @Override
    public double getFunctionValue(double x) {
        return sin.getFunctionValue(x)+cos.getFunctionValue(x);
    }
}
