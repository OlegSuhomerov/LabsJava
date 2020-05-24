package by.gsu.pms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = null;
        sc = new Scanner(new FileReader("src/in.txt"));

        double rate = Double.parseDouble(sc.nextLine().split("=")[1]);
        int[] indices = Arrays.stream(sc
                .nextLine()
                .split("=")[1]
                .split(";"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BuisnessTrip[] Trip = new BuisnessTrip[indices.length];

        for (int i=0; i < indices.length; i++){
            String account = sc.nextLine().split("=")[1];
            int transportExpenses = Integer.parseInt(sc.nextLine().split("=")[1]);
            int daysQuantity = Integer.parseInt(sc.nextLine().split("=")[1]);

            Trip[i] = new BuisnessTrip(account, transportExpenses, daysQuantity);
        }

        Arrays.sort(Trip, Comparator.comparing(BuisnessTrip::get_total).reversed());

        for(BuisnessTrip BuisnessTrip: Trip){
            BuisnessTrip.show();
        }
    }
}