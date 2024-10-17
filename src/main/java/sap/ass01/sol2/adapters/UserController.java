package sap.ass01.sol2.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sap.ass01.sol2.usecases.AddUserUseCase;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AddUserUseCase addUserUseCase;

    @Autowired
    public UserController(AddUserUseCase addUserUseCase) {
        this.addUserUseCase = addUserUseCase;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestParam String userId) {
        addUserUseCase.execute(userId, "");
        return ResponseEntity.ok("User added");
    }
}
