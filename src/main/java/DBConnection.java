import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection; // Use java.sql.Connection, not your class name

public class DBConnection {
    private Connection connection;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC driver
            String url = "jdbc:mysql://sql8.freesqldatabase.com:3306/sql8773056";
            String username = "sql8773056";
            String password = "teQMcmVMVu";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
