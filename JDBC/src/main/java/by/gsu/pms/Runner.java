package by.gsu.pms;


import by.gsu.pms.database.Record;
import by.gsu.pms.database.Select;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Record record = new Record();
        try {
            record.createTable();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        Scanner scan = new Scanner(System.in);
        Select select = new Select();
        System.out.println("Введите  номер типа треугольников:\n 1 - Равносторонний\n 2 - Равнобедренный\n 3 - Прямоугольный");
        int operation = scan.nextInt();
        if (operation == 1){
            select.get_triangles("Equilateral Triangle");
        }
        if (operation == 2){
            select.get_triangles("Isosceles Triangle");
        }
        if (operation == 3){
            select.get_triangles("Right Triangle");
        }

    }
}

