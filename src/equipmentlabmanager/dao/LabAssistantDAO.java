package equipmentlabmanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import equipmentlabmanager.db.DBConnection;
import model.Equipment;
import model.DamageReport;

public class LabAssistantDAO {

    // 1. Register lab assistant
    public boolean registerLabAssistant(String name, String email, String password) {
        boolean isRegistered = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, "lab_assistant");

            int rows = pst.executeUpdate();
            isRegistered = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isRegistered;
    }

    // 2. Add equipment
    public boolean addEquipment(Equipment equipment) {
        boolean isAdded = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO equipment (name, category, model, serial_number, status, location, purchase_date, last_maintenance_date) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, equipment.getName());
            pst.setString(2, equipment.getCategory());
            pst.setString(3, equipment.getModel());
            pst.setString(4, equipment.getSerialNumber());
            pst.setString(5, equipment.getStatus());
            pst.setString(6, equipment.getLocation());
            
            java.sql.Date purchaseDate = new java.sql.Date(equipment.getPurchaseDate().getTime());
            java.sql.Date lastMaintenanceDate = new java.sql.Date(equipment.getLastMaintenanceDate().getTime());

            pst.setDate(7, purchaseDate);
            pst.setDate(8, lastMaintenanceDate);
            

            int rows = pst.executeUpdate();
            isAdded = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAdded;
    }

    // 3. View all equipment
    public List<Equipment> getAllEquipment() {
        List<Equipment> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM equipment";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Equipment eq = new Equipment();
                eq.setName(rs.getString("name"));
                eq.setCategory(rs.getString("category"));
                eq.setModel(rs.getString("model"));
                eq.setSerialNumber(rs.getString("serial_number"));
                eq.setStatus(rs.getString("status"));
                eq.setLocation(rs.getString("location"));
                eq.setPurchaseDate(rs.getDate("purchase_date"));
                eq.setLastMaintenanceDate(rs.getDate("last_maintenance_date"));
                list.add(eq);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 4. Report damage
    public boolean reportDamage(DamageReport report) {
        boolean isReported = false;

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO damage_reports (equipment_serial, severity, description, reported_by, status, report_date) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, report.getEquipmentName());
            pst.setString(2, report.getSeverity());
            pst.setString(3, report.getIssueDescription());
            pst.setString(4, report.getReportedBy());
            pst.setString(5, report.getStatus());
            java.sql.Date reportDate = new java.sql.Date(report.getReportDate().getTime());
            pst.setDate(6, reportDate);

            int rows = pst.executeUpdate();
            isReported = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isReported;
    }

    // 5. Change password
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
