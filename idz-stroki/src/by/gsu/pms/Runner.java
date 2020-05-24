package by.gsu.pms;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        Scanner sc = null;
        StringBuilder builder = new StringBuilder();
        try {
            sc = new Scanner((new FileReader("src/text.txt")));
            while (sc.hasNextLine()){
               String[] words = sc.nextLine().split(" ");
                for(int i= 0; i <words.length; i++) {
                        builder.append(new Simvol(words[i]).numSim());
                }
                builder.append('\n');
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        StringBuilder builder = new StringBuilder();
//        try {
//            FileReader reader = new FileReader(new File("text.txt"));
//            BufferedReader bf = new BufferedReader(reader);
//            String line = bf.readLine();
//            while (line != null ){
//                String[] subString = line.split(" ");
//                for(int i= 0; i < subString.length; i++) {
//                        builder.append(new Simvol(subString[i]).numSim());
//                }
//                line = bf.readLine();
//            }
//            reader.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
