package sap.ass01.sol2.domain.models;

public interface User {
    String getUserId();

    int getCredit();

    String getRole();

    void setCredit(int credit);

    void setRole(String role);

    void setUserId(String userId);

    boolean isAdmin();

    void rechargeCredit(int amount);

    void deductCredit(int amount);
}
