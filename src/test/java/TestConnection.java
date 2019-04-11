import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.snilssave.OracleConnection.OracleConnection.getOracleConnection;


public class TestConnection {

    public static void main(String[] args) throws SQLException {


        String selectTableSQL = " SELECT * from SPR_MKB_KRATNOST";

        Statement statement = null;

        try {

            Connection connection= getOracleConnection();

            statement = connection.createStatement();


            // get data from DB
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // fetch data
            while (rs.next()) {
                String field = rs.getString("MKB_END");


                System.out.println("field : " + field);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}