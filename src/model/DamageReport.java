/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Shubham
 */
public class DamageReport {
    private String equipmentName;
    private String reportedBy;
    private String issueDescription;
    private String severity;
    private String status;
    private Date reportDate;

    public DamageReport() {}

    public DamageReport(String equipmentName, String reportedBy, String issueDescription, String severity, String status, Date reportDate) {
        this.equipmentName = equipmentName;
        this.reportedBy = reportedBy;
        this.issueDescription = issueDescription;
        this.severity = severity;
        this.status = status;
        this.reportDate = reportDate;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "DamageReport{" +
                "equipmentName='" + equipmentName + '\'' +
                ", reportedBy='" + reportedBy + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", severity='" + severity + '\'' +
                ", status='" + status + '\'' +
                ", reportDate=" + reportDate +
                '}';
}}
