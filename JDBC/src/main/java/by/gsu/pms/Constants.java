package by.gsu.pms;

public class Constants {

    public static final String URL = "jdbc:sqlite:D:/JavaLabs/JDBC/src/main/java/by/gsu/pms/triangle.db";

    public static final String DROP =  "DROP TABLE IF EXISTS angle;";
    public static final String CreateTableAngle = "CREATE TABLE IF NOT EXISTS angle (\n" +
            "\tid INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\tangle_1_1 INTEGER,\n" +
            "\tangle_1_2 INTEGER,\n" +
            "\tangle_2_1 INTEGER,\n" +
            "\tangle_2_2 INTEGER,\n" +
            "\tangle_3_1 INTEGER,\n" +
            "\tangle_3_2 INTEGER\n" +
            ");\n";
}
