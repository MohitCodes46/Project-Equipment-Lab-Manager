package service;

public class SessionService {

    private static String currentUserEmail;
    private static String currentUserName;
    private static String currentUserRole;

    // Set session on login
    public static void startSession(String name, String email, String role) {
        currentUserName = name;
        currentUserEmail = email;
        currentUserRole = role;
    }

    // Get current session details
    public static String getUserName() {
        return currentUserName;
    }

    public static String getUserEmail() {
        return currentUserEmail;
    }

    public static String getUserRole() {
        return currentUserRole;
    }

    // Logout user
    public static void clearSession() {
        currentUserEmail = null;
        currentUserName = null;
        currentUserRole = null;
    }
}
