package functions.meta;

import functions.Function;

public class Composition implements Function {

    private Function fun1,fun2;

    public Composition(Function f1, Function f2)
    {
        this.fun1=f1;
        this.fun2=f2;
    }


    public double getLeftDomainBorder() {
        return fun1.getLeftDomainBorder();
    }


    public double getRightDomainBorder() {
        return fun1.getRightDomainBorder();
    }


    public double getFunctionValue(double x) {
        return fun1.getFunctionValue(fun2.getFunctionValue(x));
    }
}
