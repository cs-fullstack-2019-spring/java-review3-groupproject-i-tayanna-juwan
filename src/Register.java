import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register
{
    private String name;
    private String password;

    public  void checkname (String name)
    {
        String SQL= "Select username from userinfo where username =?";

        try
        {
            Databaseconnection.connect();
            PreparedStatement pstmnt = Databaseconnection.connect().prepareStatement(SQL);
            System.out.println("Test");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
