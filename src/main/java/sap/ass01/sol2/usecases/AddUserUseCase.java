package sap.ass01.sol2.usecases;

import sap.ass01.sol2.kernel.services.UserServicePlugin;

public class AddUserUseCase {
    private final UserServicePlugin userServicePlugin;

    public AddUserUseCase(UserServicePlugin userServicePlugin) {
        this.userServicePlugin = userServicePlugin;
    }

    public void execute(String userId, String userName) {
        userServicePlugin.addUser(userId, userName);
    }
}
