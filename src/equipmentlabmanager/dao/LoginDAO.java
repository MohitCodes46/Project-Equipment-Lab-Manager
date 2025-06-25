package equipmentlabmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equipmentlabmanager.db.DBConnection;

public class LoginDAO {

    // 1. Authenticate user
    public boolean authenticate(String email, String password) {
        boolean isAuthenticated = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAuthenticated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }

    // 2. Get user role by email
    public String getUserRole(String email) {
        String role = null;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT role FROM users WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    // 3. Check if user exists (for registration)
    public boolean checkIfUserExists(String email) {
        boolean exists = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT email FROM users WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }
}
