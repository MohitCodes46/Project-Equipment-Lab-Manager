package equipmentlabmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import equipmentlabmanager.db.DBConnection;

public class ManagementDAO {

    public boolean registerManagement(String name, String email, String password) {
        boolean isRegistered = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, "management");

            int rows = pst.executeUpdate();
            isRegistered = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isRegistered;
    }
}
