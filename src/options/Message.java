package options;

import options.Databaseconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Message
{
    public static String recipient,subject,body,isImport;
    public static int recipientID;
    public static boolean nameLoop=true,isImportBoolean;
    public static void writeMessage() {
        Scanner scanner = new Scanner(System.in);  //list all of the usernames
        while (nameLoop) {
            String SQL = "Select username from userinfo";
            try {
                Databaseconnection.connect();
                PreparedStatement pstmt = Databaseconnection.connect().prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString(1));

                }

                System.out.println("Enter the name of your recipent");  //needs a loop. Ask the user for a recipient to send message
                recipient = scanner.nextLine();
                String namechecker = "Select userid from userinfo where username=?"; //returns both the id and the username later store the id in a variable
                try {
                    Databaseconnection.connect();
                    PreparedStatement statement = Databaseconnection.connect().prepareStatement(namechecker);
                    statement.setString(1, recipient);
                    ResultSet result = statement.executeQuery();
                    if (rs.next()) {
                        recipientID = rs.getInt(1);
                        nameLoop=false;
                        scanner.nextLine();
                    } else {
                        System.out.println("No user match");
                        scanner.nextLine();
                    }


                } catch (SQLException e) {    // inner catch for finding recipient
                    System.out.println(e.getMessage());

                }

            } catch (SQLException e) { // outer catch for finding recipient
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Enter your subject");
        subject=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter your body");
        body=scanner.nextLine();
        scanner.nextLine();
        while(!isImport.equalsIgnoreCase("yes") && !isImport.equalsIgnoreCase("no"))
        {
            System.out.println("Is this message important? Select yes or no");
            isImport = scanner.nextLine();
            scanner.nextLine();

        }

        if (isImport.equalsIgnoreCase("yes"))
        {
            isImportBoolean=true;
        }

        else
        {
            isImportBoolean=false;
        }



    }

}
