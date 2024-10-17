package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.User;
import sap.ass01.sol2.domain.repositories.UserRepository;

public class GetUserUseCase {
    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user;
    }
}
