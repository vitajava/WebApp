package ua.ievleva.enums;

public enum UserRole {
    USER("user"), ADMIN("admin");

    private String role;

    UserRole (String role) {
        this.role = role;
    }
    public String getUserRole() {
        return role;

    }
    public static UserRole getUserRole(String role) {
        return UserRole.valueOf(role);
    }
}
