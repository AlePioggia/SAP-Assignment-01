
package sap.ass01.sol1.service.plugins;

import java.util.List;

import sap.ass01.sol1.kernel.Plugin;
import sap.ass01.sol1.service.models.User;

public interface UserServicePlugin extends Plugin {

    void addUser(String userId);

    User getUser(String userId);

    void removeUser(String userId);

    void updateUser(User user);

    List<User> getUsers();
}
