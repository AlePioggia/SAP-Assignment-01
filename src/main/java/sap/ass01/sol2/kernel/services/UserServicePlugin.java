package sap.ass01.sol2.kernel.services;

import sap.ass01.sol2.domain.models.User;

public interface UserServicePlugin {
    public void addUser(String userId, String name);

    public User getUser(String userId);
}
