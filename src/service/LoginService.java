package service;

import equipmentlabmanager.dao.LoginDAO;

public class LoginService {

    private final LoginDAO loginDAO;

    public LoginService() {
        loginDAO = new LoginDAO();
    }

    // Authenticate login
    public boolean authenticate(String email, String password) {
        return loginDAO.authenticate(email, password);
    }

    // Get user role after login
    public String getUserRole(String email) {
        return loginDAO.getUserRole(email);
    }

    // Check if email already exists
    public boolean isUserAlreadyRegistered(String email) {
        return loginDAO.checkIfUserExists(email);
    }
    
    public boolean checkIfUserExists(String email) {
        return loginDAO.checkIfUserExists(email);
    }
}
