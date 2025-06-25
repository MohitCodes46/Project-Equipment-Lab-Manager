package service;

import equipmentlabmanager.dao.DamageReportDAO;
import model.DamageReport;

import java.util.List;

public class DamageReportService {

    private final DamageReportDAO damageReportsDAO;

    public DamageReportService() {
        damageReportsDAO = new DamageReportDAO();
    }

    // Get all reported equipment damage
    public List<DamageReport> getAllReports() {
        return damageReportsDAO.getAllReports();
    }

    // (Optional) Add filter methods later
    // public List<DamageReport> getReportsBySeverity(String severity) { ... }
    // public List<DamageReport> getReportsByStatus(String status) { ... }
}
