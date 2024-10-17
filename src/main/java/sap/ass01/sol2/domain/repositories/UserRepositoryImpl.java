package sap.ass01.sol2.domain.repositories;

import sap.ass01.sol2.domain.models.User;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getUserId(), user);
    }

    @Override
    public void delete(String userId) {
        users.remove(userId);
    }

    @Override
    public User findById(String userId) {
        return users.get(userId);
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(users.values());
    }

}
