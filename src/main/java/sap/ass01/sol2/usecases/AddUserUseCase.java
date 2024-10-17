package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.User;
import sap.ass01.sol2.domain.models.UserImpl;
import sap.ass01.sol2.domain.models.UserImpl.Role;
import sap.ass01.sol2.domain.repositories.UserRepository;

public class AddUserUseCase {
    private final UserRepository userRepository;

    public AddUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String userId, String userName) {
        if (userRepository.findById(userId) != null) {
            throw new IllegalArgumentException("User already exists");
        }

        User newUser = new UserImpl(userId, 0, Role.USER);
        userRepository.save(newUser);
    }
}
