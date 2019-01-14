package task13;

public class WorkThread implements Runnable {
    //поля
    private int number_of_points;
    private double x, y;
    private int hints = 0;
    private Thread t;

    //конструктор
    public WorkThread(int number_of_points) {
        this.number_of_points = number_of_points;
        t = new Thread(this, "ThN" + this.hashCode());
        t.start();                  //запуск потока
        try {
            t.join();                   //пытаемся ждать завершение потока
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    //метод run
    @Override
    public void run() {
        for (int i = 0; i < number_of_points; i++) {
            x = Math.random();                      //задаем х у
            y = Math.random();
            if (x*x + y*y <= 1) {
                hints++;
                System.out.println(t.getName());
            }
        }
        System.out.println("hints T: " + hints);
        EvaluateContainer.wholeHints = EvaluateContainer.wholeHints + hints;
    }
}
    class EvaluateContainer {
    public static volatile int wholeHints;
}


