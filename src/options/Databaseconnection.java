package options;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {
    private static String url = "jdbc:postgresql://138.197.107.95:5432/group4";
    private static String user = "student";
    private static String password = "C0d3Cr3w";

    public static  Connection connect() {
        Connection connect = null;
        try{

            connect = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return connect;
    }
}
