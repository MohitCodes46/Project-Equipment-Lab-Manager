package equipmentlabmanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import equipmentlabmanager.db.DBConnection;
import model.User;

public class AdminDAO {

    // 1. Register a new admin
    public boolean registerAdmin(String name, String email, String password) {
        boolean isRegistered = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, "admin");

            int rows = pst.executeUpdate();
            isRegistered = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isRegistered;
    }

    // 2. View all users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    // 3. Update user by email
    public boolean updateUser(User user) {
        boolean isUpdated = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE users SET name = ?, password = ?, role = ? WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getRole());
            pst.setString(4, user.getEmail());

            int rows = pst.executeUpdate();
            isUpdated = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    // 4. Delete user by email
    public boolean deleteUser(String email) {
        boolean isDeleted = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM users WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);

            int rows = pst.executeUpdate();
            isDeleted = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }

    // 5. Change admin password
    public boolean changePassword(String email, String newPassword) {
        boolean isChanged = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE users SET password = ? WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, newPassword);
            pst.setString(2, email);

            int rows = pst.executeUpdate();
            isChanged = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isChanged;
    }
}
