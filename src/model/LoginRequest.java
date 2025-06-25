package model;

/**
 * This class holds user login credentials temporarily
 * before authentication takes place.
 */
public class LoginRequest {
    private String email;
    private String password;
    private String role;

    // Default constructor
    public LoginRequest() {}

    // Parameterized constructor
    public LoginRequest(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Optional: toString() method
    @Override
    public String toString() {
        return "LoginRequest{" +
                "email='" + email + '\'' +
                ", password='********'" +
                ", role='" + role + '\'' +
                '}';
    }
}
