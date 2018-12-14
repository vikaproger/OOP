/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions.basic;

import functions.Function;

/**
 *
 * @author vlad
 */
public class Log implements Function {

    private double base;

    public Log(double bx) {
        if (bx > 0 && bx != 1) {
            this.base = bx;
        }
    }

    @Override
    public double getLeftDomainBorder() {
        return 0;
    }

    @Override
    public double getRightDomainBorder() {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double getFunctionValue(double x) {
        if (x > 0) {
            return Math.log(x) / Math.log(base);
        } else {
            return Double.NaN;
        }
    }

}
