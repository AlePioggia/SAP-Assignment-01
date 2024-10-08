package sap.ass01.sol1.presentation.dto;

public class UserDTO implements UserData {
    private String userId;
    private String name;
    private int credit;

    public UserDTO(String userId, String name, int credit) {
        this.userId = userId;
        this.name = name;
        this.credit = credit;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCredit() {
        return credit;
    }

}
