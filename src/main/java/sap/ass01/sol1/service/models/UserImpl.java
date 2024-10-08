package sap.ass01.sol1.service.models;

public class UserImpl implements User {

    private String userId;
    private int credit;
    private String role;

    public enum Role {
        USER, ADMIN
    }

    public UserImpl(String userId, int credit, Role role) {
        this.userId = userId;
        this.credit = credit;
        this.role = role.toString();
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public int getCredit() {
        return credit;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean isAdmin() {
        return Role.ADMIN.toString().equals(role);
    }

    @Override
    public void rechargeCredit(int amount) {
        if (amount > 0) {
            this.credit += amount;
        } else {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    @Override
    public void deductCredit(int amount) {
        if (amount > 0 && this.credit >= amount) {
            this.credit -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient credit or invalid amount.");
        }
    }

    @Override
    public String toString() {
        return "User [credit=" + credit + ", role=" + role + ", userId=" + userId + "]";
    }

}
