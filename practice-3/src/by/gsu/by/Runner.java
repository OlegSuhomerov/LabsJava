import by.gsu.by.Byn;
import by.gsu.by.Purchase;
import by.gsu.by.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("src/in.txt"));
            final int PURCHASES_NUMBER = 6;
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            Purchase max = new Purchase("", new Byn(0), 0);
            boolean flag = true;
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                if (purchases[i].getCost().compareTo(max.getCost()) > 0) {
                    max = purchases[i];
                }
                if (flag) {
                    flag = purchases[i].equals(purchases[0]);
                }
            }
            System.out.println("\nМаксимальная покупка " + max + "\n");
            if (flag) {
                System.out.println("Все покупки равны");
            } else {
                System.out.println("Покупки не равны");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Входной файл не найден");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}