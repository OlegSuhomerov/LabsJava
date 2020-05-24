package by.gsu.pms;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Comparator;
import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;


public class Runner {
    public static void main(String[] args) throws IOException {

        String line;

        ArrayList<Purchase> pur= new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/in.csv"));
        boolean firstLine = true;

        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
               continue;
           }

            String[] params = line.split(";");
            if (params.length == 3) {
                pur.add(
                        new Purchase(params[0],
                        Integer.parseInt(params[1]),
                        Integer.parseInt(params[2])));
            } else if (params.length == 4) {
                pur.add(
                        new PricePurchase(params[0],
                        Integer.parseInt(params[1]),
                        Integer.parseInt(params[2]),
                        Integer.parseInt(params[3])));
            }
        }
        reader.close();

        for (Purchase purchase: pur){
            System.out.println(purchase.toString());
        }

        System.out.println("Элементы с индексом 6:");
        System.out.println(pur.get(6).toString());

        Iterator<Purchase> iter = pur.iterator();
        while (iter.hasNext()){
            Purchase purchase = iter.next();
            if (purchase.getPrice() < 10000){
                iter.remove();
            }
        }

        for (Purchase purchase: pur){
            System.out.println(purchase.toString());
        }

        Comparator<Purchase> compBin = Comparator.comparingInt(Purchase::getCost);

        int index = Collections.binarySearch(pur, new Purchase("", 35000, 0), compBin);
        System.out.println("Индекс равен: " + index);
    }
}