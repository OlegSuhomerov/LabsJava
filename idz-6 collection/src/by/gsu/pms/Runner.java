package by.gsu.pms;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;
        List<Patient> list = new ArrayList<>();
        try{
            sc = new Scanner(new FileReader("src/patient.txt"));

            while (sc.hasNext()){
                String[] line = sc.nextLine().split(" ");
                Patient patient = new Patient(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], Integer.parseInt(line[5]), Integer.parseInt(line[6]), line[7]);
                list.add(patient);
            }
            Collections.sort(list);

            FileWriter writer = new FileWriter("1.txt");

            for (Patient p: list) {
                System.out.println(p);
                writer.write(p.toString());
                writer.append('\n');
            }
            writer.flush();
            Scanner in = new Scanner(System.in);

            System.out.print("Введите диагноз");
            String diagnosis = in.next();



            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getDiagnosis().equals(diagnosis)){
                    System.out.println(list.get(i));
                }
            }

            System.out.print("Введите интервал мед. карт пациентов");
            int min = in.nextInt();
            int max = in.nextInt();

            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getNumMedCard() >= min && list.get(i).getNumMedCard() <= max){
                    System.out.println(list.get(i));
                }
            }

        } catch (Exception e){
            System.err.println(e);
        }

    }
}
