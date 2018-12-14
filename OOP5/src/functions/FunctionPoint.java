/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.io.Serializable;

/**
 *
 * @author Home
 */
public class FunctionPoint implements Serializable {
    public double x,y;
    public FunctionPoint (double x, double y)
    {
        this.x= x;
        this.y= y;
    }
    public FunctionPoint(FunctionPoint point) {
        this.x = point.x;
        this.y = point.y;
    }

    public FunctionPoint (){
        this.x=0;
        this.y=0;
    }
    public double getX()
    {
        return this.x=x;
    }
     public double getY()
    {
        return this.y=y;
    }
     public double setX(double x)
    {
        return this.x=x;
    }
     public double setY(double y)
    {
        return this.y=y;
    }


    public String toString() {

       return new String("("+ getX()+","+getY()+")");
    }

    public boolean equals(Object o) {

        if (o instanceof FunctionPoint) {
            FunctionPoint point = (FunctionPoint) o;
            if (this.x == point.x) {
                if (this.y == point.y) {
                    return true;
                }
                else return false;
            }
            else return false;
        } else return false;
    }

    public int hashCode(){
        int hash = 7;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    public Object clone() {
        return new FunctionPoint(this);

    }

}
    
