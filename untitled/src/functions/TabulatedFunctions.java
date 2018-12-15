package functions;

import java.io.*;

public class TabulatedFunctions{

    private TabulatedFunctions() {
    }

    public static TabulatedFunction tabulate(Function function, double leftX, double rightX, int pointsCount) {
        if (leftX < function.getLeftDomainBorder() || rightX > function.getRightDomainBorder())
            throw new IllegalArgumentException();

        FunctionPoint[] array = new FunctionPoint[pointsCount];
        array[0] = new FunctionPoint(leftX, function.getFunctionValue(leftX));

        double step = (rightX - leftX) / (pointsCount - 1);
        for (int i = 1; i < pointsCount; i++) {

            array[i] = new FunctionPoint(array[i - 1].x + step, function.getFunctionValue(array[i - 1].x + step));

        }

        return new ArrayTabulatedFunction(array);
    }

    public static void outputTabulatedFunction(TabulatedFunction function, OutputStream out) throws IOException
    {
          int pointCount= function.getPointsCount();
          DataOutputStream stream=new DataOutputStream(out);
          stream.writeInt(pointCount);

          for (int i=0;i<pointCount; i++)
          {
              stream.writeDouble(function.getPointX(i));
              stream.writeDouble(function.getPointY(i));
          }
          stream.flush();
    }

    public static TabulatedFunction inputTabulatedFunction(InputStream in) throws IOException
    {
        DataInputStream stream= new DataInputStream(in);
        int pointCount=stream.readInt();

        FunctionPoint arr[]= new FunctionPoint[pointCount];

        for(int i=0;i< pointCount;i++)
        {
            arr[i]= new FunctionPoint(stream.readDouble(),stream.readDouble());
        }

        return new ArrayTabulatedFunction(arr);
    }

    public static void writeTabulatedFunction(TabulatedFunction function, Writer out){
         PrintWriter writer=new PrintWriter(out);
         int pointCount=function.getPointsCount();

         writer.println(pointCount);

         for (int i=0; i<pointCount; i++){
             writer.println(function.getPointX(i));
             writer.println(function.getPointY(i));
         }
    }

    public static TabulatedFunction readTabulatedFunction(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();

        int pointCount = (int) tokenizer.nval;

        FunctionPoint points[] = new FunctionPoint[pointCount];
        double x, y;
        for (int i = 0; i < pointCount; i++) {
            tokenizer.nextToken();
            x = tokenizer.nval;
            tokenizer.nextToken();
            y = tokenizer.nval;

            points[i] = new FunctionPoint(x, y);
        }

        return new ArrayTabulatedFunction(points);

    }
}
