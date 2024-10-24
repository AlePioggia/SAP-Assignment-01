// src/main/java/sap/ass01/sol2/kernel/services/UserServicePluginImpl.java
package sap.ass01.sol2.kernel.services;

import sap.ass01.sol2.domain.models.User;
import sap.ass01.sol2.domain.models.UserImpl;
import sap.ass01.sol2.domain.models.UserImpl.Role;
import sap.ass01.sol2.domain.repositories.UserRepository;

public class UserServicePluginImpl implements UserServicePlugin {
    private final UserRepository userRepository;

    public UserServicePluginImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(String userId, String name) {
        User newUser = new UserImpl(userId, 0, Role.USER);
        userRepository.save(newUser);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId);
    }
}
