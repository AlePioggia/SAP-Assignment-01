package sap.ass01.sol1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/admin/{adminId}/addEBike")
    public ResponseEntity<String> addUser(@RequestParam String userId, @RequestParam int x, @RequestParam int y) {
        eBikeService.addUser(userId, x, y);
        return ResponseEntity.ok("User added");
    }

    @PostMapping("/admin/{adminId}/addEBike")
    public ResponseEntity<String> addEBike(@RequestParam String eBikeId, @RequestParam String userId,
            @RequestParam int x, @RequestParam int y) {
        eBikeService.addEBike(eBikeId, userId, x, y);
        return ResponseEntity.ok("EBike added");
    }

    @PostMapping("/admin/{adminId}/removeEBike")
    public ResponseEntity<String> removeEBike(@RequestParam String eBikeId) {
        eBikeService.removeEBike(eBikeId);
        return ResponseEntity.ok("EBike removed");
    }

    @PostMapping("/admin/{adminId}/removeUser")
    public ResponseEntity<String> removeUser(@RequestParam String userId) {
        eBikeService.removeUser(userId);
        return ResponseEntity.ok("User removed");
    }

    @PostMapping("/user/{userId}/startRide")
    public ResponseEntity<String> startRide(@RequestParam String userId, @RequestParam String bikeId) {
        eBikeService.startRide(userId, bikeId);
        return ResponseEntity.ok("Ride started");
    }

}
