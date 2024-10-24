package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.User;
import sap.ass01.sol2.kernel.services.UserServicePlugin;

public class GetUserUseCase {
    private final UserServicePlugin userServicePlugin;

    public GetUserUseCase(UserServicePlugin userServicePlugin) {
        this.userServicePlugin = userServicePlugin;
    }

    public User execute(String userId) {
        return userServicePlugin.getUser(userId);
    }
}
