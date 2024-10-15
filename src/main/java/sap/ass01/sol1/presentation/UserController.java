package sap.ass01.sol1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sap.ass01.sol1.kernel.Kernel;
import sap.ass01.sol1.service.plugins.UserServicePlugin;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final Kernel kernel;

    @Autowired
    public UserController(Kernel kernel) {
        this.kernel = kernel;
    }

    @PostMapping("add")
    public ResponseEntity<String> addUser(@RequestParam String userId) {
        UserServicePlugin userService = kernel.getService(UserServicePlugin.class);
        userService.addUser(userId);
        return ResponseEntity.ok("User added");
    }

    @PostMapping("remove")
    public ResponseEntity<String> removeUser(@RequestParam String userId) {
        UserServicePlugin userService = kernel.getService(UserServicePlugin.class);
        userService.removeUser(userId);
        return ResponseEntity.ok("User removed");
    }

    @GetMapping("")
    public ResponseEntity<String> getUsers() {
        UserServicePlugin userService = kernel.getService(UserServicePlugin.class);
        return ResponseEntity.ok(userService.getUsers().toString());
    }
}
