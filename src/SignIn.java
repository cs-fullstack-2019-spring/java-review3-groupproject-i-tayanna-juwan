//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class SignIn {
//    public static SignIn instance = null;
//    private static final String DB_URL = "jdbc:postgresql://138.197.107.95:5432/group4";
//    private Connection conn = null;
//
//    public static SignIn getInstance() {
//        return instance == null ? new SignIn() : instance;
//    }
//
//    private int getUserID(String username) {
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL);
//            PreparedStatement prepStmt = conn.prepareStatement("SELECT UserId FROM Userinfo WHERE name =?");
//            prepStmt.setString(1, username);
//            ResultSet rs = prepStmt.executeQuery();
//            rs.next();
//            return rs.getInt(1);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    private void insertNewUser(String username, String pass) {
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL);
//            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO SiteUser (name,password) VALUES (?,?)");
//            prepStmt.setString(1, username);
//            prepStmt.setString(2, pass);
//            prepStmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void createAccountForUser(String username) {
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL);
//            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO PaymentAccount (cash,userId) VALUES (?,?)");
//            prepStmt.setDouble(1, 0.00);
//            prepStmt.setInt(2, getUserID(username));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public int register(String username, String pass) {
//        PreparedStatement prepStmt = null;
//        try {
//            conn = DriverManager.getConnection(DB_URL);
//            prepStmt = conn.prepareStatement("SELECT COUNT(*) FROM SiteUser WHERE name=?");
//            prepStmt.setString(1, username);
//            ResultSet rs = prepStmt.executeQuery();
//            rs.next();
//            if (rs.getInt(1) <= 0) {
//                if (validatePass(pass) && validateUsername(username)) {
//                    insertNewUser(username, pass);
//                    createAccountForUser(username);
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    private boolean validateUsername(String username) {
//        return username.length() > 3;
//    }
//
//    private boolean validatePass(String pass) {
//        return pass.length() >= 10 & pass.matches(".*\\d+.*");
//    }
//
//    @Override
//    public void delete() {
//    }
//
//    @Override
//    public int login(String userName, char[] pass) {
//        try {
//            conn = DriverManager.getConnection(DB_URL);
//            PreparedStatement prepStmt = conn
//                    .prepareStatement("SELECT name,password FROM SiteUser WHERE name=? AND password=?");
//            prepStmt.setString(1, userName);
//            prepStmt.setString(2, new String(pass));
//            ResultSet rs = prepStmt.executeQuery();
//            if (rs.next()) {
//                return 1;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//}
