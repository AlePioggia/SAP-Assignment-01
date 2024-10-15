package sap.ass01.sol1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sap.ass01.sol1.persistance.UserRepository;
import sap.ass01.sol1.service.models.User;
import sap.ass01.sol1.service.models.UserImpl;
import sap.ass01.sol1.service.models.UserImpl.Role;
import sap.ass01.sol1.service.plugins.UserServicePlugin;

public class UserServiceImpl implements UserServicePlugin {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(String userId) {
        User user = new UserImpl(userId, 0, Role.USER);
        System.out.println("User added in repository");
        userRepository.save(user);
    }

    @Override
    public void removeUser(String userId) {
        userRepository.delete(userId);
    }

    @Override
    public void updateUser(User user) {
        if (user == null || userRepository.findById(user.getUserId()) == null) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void initialize() {
        System.out.println("User service initialized");
    }

    @Override
    public String getName() {
        return "UserService";
    }
}
