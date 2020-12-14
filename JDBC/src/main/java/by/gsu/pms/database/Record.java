package by.gsu.pms.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import static by.gsu.pms.Constants.*;

public class Record {

    public void createTable() throws SQLException {
        Record app = new Record();

        Connect connector = new Connect();

        PreparedStatement statement = null;
        try (Connection connection = connector.connect(URL)) {
            statement = connection.prepareStatement(DROP);
            statement.executeUpdate();
            statement = connection.prepareStatement(CreateTableAngle);
            statement.executeUpdate();

            app.insert(0,0,3,0,3,4);
            app.insert(0,3,8,0,8,6);
            app.insert(0,0,2,0,1, Math.sqrt(3));

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        finally {
            assert statement != null;
            statement.close();
        }
    }


    public void insert(int angle_1_1, int angle_1_2, int angle_2_1, int angle_2_2, int angle_3_1, double angle_3_2) {
        String sql = "INSERT INTO angle (angle_1_1,angle_1_2,angle_2_1,angle_2_2,angle_3_1,angle_3_2) VALUES (?,?,?,?,?,?);";

        Connection conn;

        Connect connector = new Connect();
        PreparedStatement statement = null;
        conn = connector.connect(URL);

        try{

            PreparedStatement table = conn.prepareStatement(sql);

            table.setInt(1, angle_1_1);
            table.setInt(2, angle_1_2);
            table.setInt(3, angle_2_1);
            table.setInt(4, angle_2_2);
            table.setInt(5, angle_3_1);
            table.setDouble(6, angle_3_2);
            table.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assert statement != null;
    }
}
