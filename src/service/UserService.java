package service;

import equipmentlabmanager.dao.LabAssistantDAO;

public class UserService {

    private final LabAssistantDAO labAssistantDAO;

    public UserService() {
        labAssistantDAO = new LabAssistantDAO();
    }

    // Register a new lab assistant (you can add other roles later if needed)
    public boolean registerLabAssistant(String name, String email, String password) {
        return labAssistantDAO.registerLabAssistant(name, email, password);
    }

    // Change password
    public boolean changePassword(String email, String newPassword) {
        return labAssistantDAO.changePassword(email, newPassword);
    }
}
