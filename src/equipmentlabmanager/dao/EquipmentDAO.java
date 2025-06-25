package equipmentlabmanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import equipmentlabmanager.db.DBConnection;
import equipmentlabmanager.util.DBUtil;
import model.Equipment;

public class EquipmentDAO {

    // 1. Add equipment
    public boolean addEquipment(Equipment e) {
        boolean isAdded = false;
        String sql = "INSERT INTO equipment (name, category, model, serial_number, status, location, purchase_date, last_maintenance_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, e.getName());
            pst.setString(2, e.getCategory());
            pst.setString(3, e.getModel());
            pst.setString(4, e.getSerialNumber());
            pst.setString(5, e.getStatus());
            pst.setString(6, e.getLocation());
            pst.setDate(7, new java.sql.Date(e.getPurchaseDate().getTime()));
            pst.setDate(8, new java.sql.Date(e.getLastMaintenanceDate().getTime()));

            isAdded = pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isAdded;
    }

    // 2. View all equipment
    public List<Equipment> getAllEquipment() {
        List<Equipment> list = new ArrayList<>();
        String sql = "SELECT * FROM equipment";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Equipment e = new Equipment();
                e.setName(rs.getString("name"));
                e.setCategory(rs.getString("category"));
                e.setModel(rs.getString("model"));
                e.setSerialNumber(rs.getString("serial_number"));
                e.setStatus(rs.getString("status"));
                e.setLocation(rs.getString("location"));
                e.setPurchaseDate(rs.getDate("purchase_date"));
                e.setLastMaintenanceDate(rs.getDate("last_maintenance_date"));
                list.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    // 3. Update equipment
    public boolean updateEquipment(Equipment e) {
        boolean isUpdated = false;
        String sql = "UPDATE equipment SET name = ?, category = ?, model = ?, status = ?, location = ?, purchase_date = ?, last_maintenance_date = ? WHERE serial_number = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, e.getName());
            pst.setString(2, e.getCategory());
            pst.setString(3, e.getModel());
            pst.setString(4, e.getStatus());
            pst.setString(5, e.getLocation());
            pst.setDate(6, new java.sql.Date(e.getPurchaseDate().getTime()));
            pst.setDate(7, new java.sql.Date(e.getLastMaintenanceDate().getTime()));
            pst.setString(8, e.getSerialNumber());

            isUpdated = pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isUpdated;
    }

    // 4. Delete equipment
    public boolean deleteEquipment(String serialNumber) {
        boolean isDeleted = false;
        String sql = "DELETE FROM equipment WHERE serial_number = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, serialNumber);
            isDeleted = pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isDeleted;
    }
    
    public void updateEquipmentField(String serial, String field, String newValue) {
    try (Connection con = DBUtil.getConnection()) {
        String query = "UPDATE equipment SET " + field + " = ? WHERE serial_number = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, newValue);
        ps.setString(2, serial);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public boolean isSerialNumberExists(String serialNumber) {
    String query = "SELECT 1 FROM equipment WHERE serial_number = ?";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setString(1, serialNumber);
        ResultSet rs = ps.executeQuery();

        return rs.next(); // returns true if record is found

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
}



