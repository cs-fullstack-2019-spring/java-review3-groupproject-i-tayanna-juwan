import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register
{
    private String user_email;
    private String password;

    public static void checkname (String name)
    {
        String SQL_name= "Select username from userinfo where username =?";
        String SQL_namepass= "Insert into userinfo(username,password) Values(?,?)";
        try
        {
            Databaseconnection.connect();
            PreparedStatement pstmnt = Databaseconnection.connect().prepareStatement(SQL_name);
            pstmnt.setString(1,name);
            ResultSet rs = pstmnt.executeQuery();
            if(rs.next())
            {
                System.out.println("User already exist");
            }
            else
            {

                pstmnt.setString(1,name);
                pstmnt
             System.out.println("This user can be used");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
