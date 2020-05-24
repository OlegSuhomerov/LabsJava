import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        List<House> list = new ArrayList<>();
        String file = "src/in.txt";
        Sereliaz ser = new Sereliaz(file);
        list=ser.deser();
        System.out.println(list);
        Scanner in = new Scanner(System.in);
        int numHouse = 0;

        System.out.print("Input number room: ");

        int num = in.nextInt();

        try{
            for (int i = 0; i<list.size(); i++){
                if (list.get(i) != null &&  list.get(i).getNumberRooms() == num){
                    numHouse++;
                    System.out.println(list.get(i));
                }
            }
        } catch (NullPointerException npe){
            System.out.println("Поле недолжно быть пустым!");
        }

        System.out.println("Кол-во квартир имеющих заданое кол-во комнат = " + numHouse + '\n');

        System.out.println("Введите кол-во комнат и промежуток этажей : ");
        int numRoom = in.nextInt();
        int minFloor = in.nextInt();
        int maxFloor = in.nextInt();
        numHouse = 0;
        for (int i = 0; i<list.size(); i++){
            if (list.get(i) != null &&  list.get(i).getNumberRooms()==numRoom && list.get(i) .getFloor()>=minFloor && list.get(i) .getFloor()<=maxFloor){
                numHouse++;
                System.out.println(list.get(i) );
            }
        }
        System.out.println("Кол-во квартир имеющих заданое кол-во комнат и находятся на промежутке заданых этажей= " + numHouse + '\n');

        System.out.println("Введите минимальную площадь квартиры  : ");
        int entArea = in.nextInt();
        numHouse = 0;
        for (int i = 0; i<list.size(); i++){
            if (list.get(i)  != null && list.get(i).getArea()>=entArea){
                numHouse++;
                System.out.println(list.get(i) );
            }
        }
        System.out.println("Кол-во квартир имеющие большую площадь заданой= " + numHouse + '\n');
        ser.ser(list);

        try{
            int b = 10;
            int sum = b / 0;
        } catch(ArithmeticException ae) {
            System.out.println("На ноль делить нельзя!");
        }
    }
}
