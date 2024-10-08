package sap.ass01.sol1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sap.ass01.sol1.service.EBikeService;

@RestController
@RequestMapping("/api")
public class EBikeController {

    private final EBikeService eBikeService;

    @Autowired
    public EBikeController(EBikeService eBikeService) {
        this.eBikeService = eBikeService;
    }

    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestParam String userId) {
        eBikeService.addUser(userId);
        return ResponseEntity.ok("User added");
    }

    @PostMapping("addEBike")
    public ResponseEntity<String> addEBike(@RequestParam String eBikeId, @RequestParam String userId,
            @RequestParam int x, @RequestParam int y) {
        eBikeService.addEBike(eBikeId, userId, x, y);
        return ResponseEntity.ok("EBike added");
    }

    @PostMapping("removeEBike")
    public ResponseEntity<String> removeEBike(@RequestParam String eBikeId) {
        eBikeService.removeEBike(eBikeId);
        return ResponseEntity.ok("EBike removed");
    }

    @PostMapping("removeUser")
    public ResponseEntity<String> removeUser(@RequestParam String userId) {
        eBikeService.removeUser(userId);
        return ResponseEntity.ok("User removed");
    }

    @PostMapping("startRide")
    public ResponseEntity<String> startRide(@RequestParam String userId, @RequestParam String bikeId) {
        eBikeService.startRide(userId, bikeId);
        return ResponseEntity.ok("Ride started");
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok(eBikeService.getUsers().toString());
    }

    @GetMapping("/bikes")
    public ResponseEntity<String> getBikes() {
        return ResponseEntity.ok(eBikeService.getBikes().toString());
    }

}
