/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import functions.meta.*;

/**
 *
 * @author vlad
 */
public class Functions {

    private Functions() {
    }

    public static Function shift(Function f, double shiftX, double shiftY) {
        return new Shift(f, shiftX, shiftY);

    }

    public static Function scale(Function f, double scaleX, double scaleY) {
        return new Scale(f, scaleX, scaleY);
    }

    public static Function power(Function f, double power) {
        return new Power(f, power);
    }

    public static Function sum(Function f1, Function f2) {
        return new Sum(f1, f2);
    }

    public static Function mult(Function f1, Function f2) {
        return new Mult(f1, f2);
    }

    public static Function composition(Function f1, Function f2) {
        return new Composition(f1, f2);
    }

    public static double integrate(Function function, double leftX, double rightX, double step) {
        if (leftX < function.getLeftDomainBorder() || rightX > function.getRightDomainBorder()) {
            throw new IllegalArgumentException();
        }

        double result = 0, current = leftX;

        while (current < rightX) {
            result += (function.getFunctionValue(current) + function.getFunctionValue(current + step)) * step / 2;
            current += step;
        }

        current -= step;

        result += (function.getFunctionValue(rightX) + function.getFunctionValue(current)) * (rightX - current) / 2;

        return result;

    }

}
