/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

/**
 *
 * @author Home
 */
public interface TabulatedFunction extends Function , Cloneable{

   public int getPointsCount();

   public Object clone() throws CloneNotSupportedException;

   public void setPoint(int index, FunctionPoint point) throws FunctionPointIndexOutOfBoundsException, InappropriateFunctionPointException;

   public double getPointX(int index)  throws FunctionPointIndexOutOfBoundsException;

   public void setPointX(int index, double x) throws FunctionPointIndexOutOfBoundsException, InappropriateFunctionPointException;

   public double getPointY(int index) throws FunctionPointIndexOutOfBoundsException;

   public void setPointY(int index, double y) throws FunctionPointIndexOutOfBoundsException;

    public void deletePoint(int index)throws FunctionPointIndexOutOfBoundsException,IllegalStateException;

    public void addPoint(FunctionPoint point) throws InappropriateFunctionPointException;

    public FunctionPoint getPoint (int index);

}

    

