package by.gsu.pms;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        House[] house = {
                new House(1, 17, 69, 3, 3, "Sovet street", 30, TypeBuildings.HIGH_RISE_BUILDING),
                new House(2, 2, 120, 1, 5, "Homel street", 60, TypeBuildings.COTTAGE),
                null,
                new House(3, 998, 40, 8, 2, "Ocean street", 10, TypeBuildings.HIGH_RISE_BUILDING),
                new House(4, 48, 39, 1, 2,  "Sovet street", 30,TypeBuildings.PRIVATE_HOUSE),
                new House(5, 777, 52, 6, 3, "River street", 25,TypeBuildings.HIGH_RISE_BUILDING),
                new House(6, 23, 67, 20,3, "Business street", 65, TypeBuildings.HIGH_RISE_BUILDING),
                new House(7, 1, 48, 2, 2, "Center street", 30, TypeBuildings.PRIVATE_HOUSE),
                new House(8, 14, 45, 11, 2, "Great street", 40, TypeBuildings.HIGH_RISE_BUILDING),
                new House(9, 665, 100, 1, 4, "Golden street", 10, TypeBuildings.COTTAGE),
                new House()
        };

        Scanner in = new Scanner(System.in);
        int numHouse = 0;

        System.out.print("Input number room: ");
        int num = in.nextInt();
        for (int i = 0; i<house.length; i++){
            if (house[i] != null &&  house[i].getNumberRooms()==num){
                numHouse++;
                System.out.println(house[i]);
            }
        }
        System.out.println("Кол-во квартир имеющих заданое кол-во комнат = " + numHouse + '\n');

        System.out.println("Введите кол-во комнат и промежуток этажей : ");
        int numRoom = in.nextInt();
        int minFloor = in.nextInt();
        int maxFloor = in.nextInt();
        numHouse = 0;
        for (int i = 0; i<house.length; i++){
            if (house[i] != null &&  house[i].getNumberRooms()==numRoom && house[i].getFloor()>=minFloor && house[i].getFloor()<=maxFloor){
                numHouse++;
                System.out.println(house[i]);
            }
        }
        System.out.println("Кол-во квартир имеющих заданое кол-во комнат и находятся на промежутке заданых этажей= " + numHouse + '\n');

        System.out.println("Введите минимальную площадь квартиры  : ");
        int entArea = in.nextInt();
        numHouse = 0;
        for (int i = 0; i<house.length; i++){
            if (house[i] != null && house[i].getArea()>=entArea){
                numHouse++;
                System.out.println(house[i]);
            }
        }
        System.out.println("Кол-во квартир имеющие большую площадь заданой= " + numHouse + '\n');
    }


}
