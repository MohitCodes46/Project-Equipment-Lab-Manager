package model;

/**
 * Session class holds login state for the current user.
 */
public class Session {
    private static String userName;
    private static String role;

    public static void setSession(String uname, String r) {
        userName = uname;
        role = r;
    }

    public static void clearSession() {
        userName = null;
        role = null;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Session{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
