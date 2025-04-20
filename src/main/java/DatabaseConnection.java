import java.sql.*;

public class DatabaseConnection {
    private static Connection connection;
    private static DBConnection dbConnection;

    // Singleton connection
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            if (dbConnection == null) {
                dbConnection = new DBConnection();
            }
            connection = dbConnection.getConnection();
            if (connection == null) {
                throw new SQLException("Failed to establish database connection");
            }
        }
        return connection;
    }

    // SELECT queries
    public static ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement statement = prepareStatement(query, params);
        return statement.executeQuery();
    }

    // INSERT, UPDATE, DELETE
    public static int executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement statement = prepareStatement(query, params);
        return statement.executeUpdate();
    }

    // Return single value (e.g., COUNT(*), SUM, etc.)
    public static Object executeScalar(String query, Object... params) throws SQLException {
        ResultSet rs = executeQuery(query, params);
        if (rs.next()) {
            return rs.getObject(1);
        }
        return null;
    }

    // Insert and get generated key (e.g., auto-increment ID)
    public static int executeInsertWithGeneratedKey(String query, Object... params) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        statement.executeUpdate();
        ResultSet keys = statement.getGeneratedKeys();
        if (keys.next()) {
            return keys.getInt(1);
        }
        return -1;
    }

    // Check if a record exists
    public static boolean recordExists(String query, Object... params) throws SQLException {
        ResultSet rs = executeQuery(query, params);
        return rs.next();
    }

    // Start transaction
    public static void beginTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    // Commit transaction
    public static void commit() throws SQLException {
        getConnection().commit();
        getConnection().setAutoCommit(true);
    }

    // Rollback transaction
    public static void rollback() {
        try {
            getConnection().rollback();
            getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Internal: prepare statement with params
    private static PreparedStatement prepareStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement;
    }
}