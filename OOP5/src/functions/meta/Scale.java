package functions.meta;

import functions.Function;

public class Scale implements Function {

    private double multX, multY;
    private Function func;

    public Scale(Function f, double x, double y) {
        this.func = f;
        this.multX = x;
        this.multY = y;
    }


    public double getLeftDomainBorder() {
        if (multX >= 0) {
            return multX * func.getLeftDomainBorder();
        } else {
            return func.getLeftDomainBorder() / multX;
        }
    }


    public double getRightDomainBorder() {
        if (multX >= 0) {
            return multX * func.getRightDomainBorder();
        } else {
            return func.getRightDomainBorder() / multX;
        }
    }


    public double getFunctionValue(double x) {
        if (multY >= 0) {
            return multY * func.getFunctionValue(x/multX);
        } else {
            return func.getFunctionValue(x/multX) / multY;
        }
    }
}
