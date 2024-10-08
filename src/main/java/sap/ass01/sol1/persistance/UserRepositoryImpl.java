package sap.ass01.sol1.persistance;

import sap.ass01.sol1.service.models.User;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

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
