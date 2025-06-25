package model;

import java.util.Date;

public class Equipment {
    private String name;
    private String category;
    private String model;
    private String serialNumber;
    private String status;
    private String location;
    private Date purchaseDate;
    private Date lastMaintenanceDate; // ✅ make sure this field exists

    // 👉 Add Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    // 👉 Add Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }
}
