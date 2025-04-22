package DAO;
import Database.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {

    public void addUser(User user) {
        String sql = "INSERT INTO users (email, password, first_name, last_name, full_name, birthday, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            DBConnection bd = new DBConnection();
            Connection conn = bd.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getFullName());
            stmt.setDate(6, new java.sql.Date(user.getBirthday().getTime()));
            stmt.setString(7, user.getAddress());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        boolean status = false;

        try {
            DBConnection bd = new DBConnection();
            Connection conn = bd.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public User getUserByemail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        User user = null;

        try {
            DBConnection bd = new DBConnection();
            Connection conn = bd.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setFullName(rs.getString("full_name"));
                user.setBirthday(rs.getDate("birthday"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }



    public void updateUser(User user) {
        String sql = "UPDATE users SET password = ?, first_name = ?, last_name = ?, full_name = ?, birthday = ?, address = ?WHERE email = ?";

        try {
            DBConnection bd = new DBConnection();
            Connection conn = bd.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getFullName());
            stmt.setDate(6, new java.sql.Date(user.getBirthday().getTime()));
            stmt.setString(7, user.getAddress());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String email) {
        String sql = "DELETE FROM users WHERE email = ? ";

        try{
            DBConnection bd = new DBConnection();
            Connection conn = bd.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
