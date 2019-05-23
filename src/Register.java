import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register extends Databaseconnection
{
    private String name;
    private String password;

    public  void checkname (String name)
    {
        String SQL= "Select username from userinfo where username =?";
        try(Connection conn=connect());
            PreparedStatement pstmnt = conn.prepareStatement(SQL))
        {
            System.out.println("Test");
        }
        catch(SQL Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
