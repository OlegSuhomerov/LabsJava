package by.gsu.pms;

public class Calculator extends Thread{

    private long result;
    private final int minValue;
    private final int maxValue;

    public long getResult() {
        return this.result;
    }

    public Calculator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Поток " + threadName + " начинается...");
        for (int i = this.minValue; i <= this.maxValue; i++) {
            if (i % 3 == 0) {
                this.result += i;
            }
        }
        System.out.println("Результат потока " + threadName + " равен " + this.result);
    }
}