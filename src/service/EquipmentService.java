package service;

import equipmentlabmanager.dao.EquipmentDAO;
import model.Equipment;

import java.util.List;

public class EquipmentService {

    private final EquipmentDAO equipmentDAO;

    public EquipmentService() {
        equipmentDAO = new EquipmentDAO();
    }

    // Add new equipment
    public boolean addEquipment(Equipment equipment) {
        return equipmentDAO.addEquipment(equipment);
    }

    // Fetch all equipment for table display
    public List<Equipment> getAllEquipment() {
        return equipmentDAO.getAllEquipment();
    }

    // Update existing equipment
    public boolean updateEquipment(Equipment equipment) {
        return equipmentDAO.updateEquipment(equipment);
    }

    // Delete equipment using serial number
    public boolean deleteEquipment(String serialNumber) {
        return equipmentDAO.deleteEquipment(serialNumber);
    }
}
