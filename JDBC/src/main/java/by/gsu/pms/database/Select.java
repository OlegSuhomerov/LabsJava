package by.gsu.pms.database;


import by.gsu.pms.model.Point;
import by.gsu.pms.model.Triangle;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static by.gsu.pms.Constants.URL;

public class Select {

    private String current_type;

//    @SneakyThrows
//    public static void main(String[] args) {
//        Record record = new Record();
//        record.createTable();
//        get_triangles();
//    }


    public void get_triangles(String triangle_type) {
        Connect connector = new Connect();
        Connection connection = connector.connect(URL);
        String query = "SELECT * FROM angle";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Triangle> triangles = new ArrayList<>();
            while (resultSet.next()) {
                triangles.add(createTriangle(resultSet));
            }
            triangles.forEach(x -> kindOfTriangle(x.getAngleList(), triangle_type));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private static String kindOfTriangle(List<Point> points, String triangle_type) {
        double line1 = distanceTo(points.get(0), points.get(1));
        double line2 = distanceTo(points.get(1), points.get(2));
        double line3 = distanceTo(points.get(2), points.get(0));

        String result = chekTriangle(line1, line2, line3);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        if (result == triangle_type) {
            System.out.println(result);
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);
        }


        return null;
    }

    public static double distanceTo(Point point, Point point2) {
        double temp = Math.pow(point.getX() - point2.getX(), 2);
        temp += Math.pow(point.getY() - point2.getY(), 2);
        return Math.sqrt(temp);
    }

    private static String chekTriangle(Double a, Double b, Double c) {
        if (a <= 0 || b <= 0 || c <= 0){
            return "InvalidInput";
        }
        else if (a >= (b + c) || c >= (b + a) || b >= (a + c)){
            return "Not a Triangle";
        }
        else if (a == b && b == c){
            return "Equilateral Triangle";
        }
        else if (((a * a) + (b * b)) == (c * c) || ((a * a) + (c * c)) == (b * b) || ((c * c) + (b * b)) == (a * a)) {
            return "Right Triangle";
        }
        else if (Objects.equals(c, a) | Objects.equals(a, b) | Objects.equals(c, b)){
            return "Isosceles Triangle";
        }
        return null;
    }

    @SneakyThrows
    private static Triangle createTriangle(ResultSet rs) {
        Point a1 = Point.builder()
                .x(rs.getInt("angle_1_1"))
                .y(rs.getInt("angle_1_2"))
                .build();
        Point a2 = Point.builder()
                .x(rs.getInt("angle_2_1"))
                .y(rs.getInt("angle_2_2"))
                .build();
        Point a3 = Point.builder()
                .x(rs.getInt("angle_3_1"))
                .y(rs.getInt("angle_3_2"))
                .build();
        Triangle triangle = Triangle.builder()
                .id(rs.getInt("id"))
                .angleList(Arrays.asList(a1, a2, a3))
                .build();
        return triangle;
    }

}
