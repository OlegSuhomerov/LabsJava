package by.gsu.pms;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите кол-во потоков: ");
        int countTreads = scan.nextInt();
        System.out.println("Введите максимальное число: ");
        int maxCount = scan.nextInt();
        System.out.println("Введите знак для выбора выражений (+, - или *)");
        String expression = scan.next();

        Threads calculator;
        calculator = new Threads(countTreads, expression, maxCount);
        calculator.execute();
        System.out.println("Результат: " + calculator.getResult());

    }
}
