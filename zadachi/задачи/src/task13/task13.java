package task13;

public class task13 {

    public static void main(String[] args) {
        int numberOfPoints = 100000;
        int numberOfThreads = 4;

        int part = numberOfPoints/numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            new WorkThread(part);
        }
        double aprox_pi = 4.0*EvaluateContainer.wholeHints / numberOfPoints;
        System.out.println("aprox_pi: " + aprox_pi);
    }
}