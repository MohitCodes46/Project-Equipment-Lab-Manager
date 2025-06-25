package equipmentlabmanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import equipmentlabmanager.db.DBConnection;
import model.DamageReport;

public class DamageReportDAO {

    // Fetch all damage reports
    public List<DamageReport> getAllReports() {
        List<DamageReport> reports = new ArrayList<>();

        String sql = "SELECT * FROM damage_reports";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                DamageReport report = new DamageReport();
                report.setEquipmentName(rs.getString("equipment_serial"));
                report.setSeverity(rs.getString("severity"));
                report.setIssueDescription(rs.getString("description"));
                report.setReportedBy(rs.getString("reported_by"));
                report.setStatus(rs.getString("status"));
                report.setReportDate(rs.getDate("report_date"));

                reports.add(report);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }
}
