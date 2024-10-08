package sap.ass01.sol1.persistance;

import sap.ass01.sol1.service.models.User;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    void save(User user);

    void delete(String userId);

    User findById(String userId);

    List<User> findAll();
}
