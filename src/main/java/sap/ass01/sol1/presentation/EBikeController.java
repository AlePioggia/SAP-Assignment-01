package sap.ass01.sol1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sap.ass01.sol1.kernel.Kernel;
import sap.ass01.sol1.service.EBikeService;

@RestController
@RequestMapping("/api")
public class EBikeController {

    private final Kernel kernel;

    @Autowired
    public EBikeController(Kernel kernel) {
        this.kernel = kernel;
    }

    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestParam String userId) {
        EBikeService eBikeService = kernel.getService(EBikeService.class);
        eBikeService.addUser(userId);
        return ResponseEntity.ok("User added");
    }

    @PostMapping("addEBike")
    public ResponseEntity<String> addEBike(@RequestParam String eBikeId, @RequestParam String userId,
            @RequestParam int x, @RequestParam int y) {
        EBikeService eBikeService = kernel.getService(EBikeService.class);
        eBikeService.addEBike(eBikeId, userId, x, y);
        return ResponseEntity.ok("EBike added");
    }

    @PostMapping("removeEBike")
    public ResponseEntity<String> removeEBike(@RequestParam String eBikeId) {
        EBikeService eBikeService = kernel.getService(EBikeService.class);
        eBikeService.removeEBike(eBikeId);
        return ResponseEntity.ok("EBike removed");
    }

    @PostMapping("removeUser")
    public ResponseEntity<String> removeUser(@RequestParam String userId) {
        EBikeService eBikeService = kernel.getService(EBikeService.class);
        eBikeService.removeUser(userId);
        return ResponseEntity.ok("User removed");
    }

    @PostMapping("startRide")
    public ResponseEntity<String> startRide(@RequestParam String userId, @RequestParam String bikeId) {
        EBikeService eBikeService = kernel.getService(EBikeService.class);
        eBikeService.startRide(userId, bikeId);
        return ResponseEntity.ok("Ride started");
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        EBikeService eBikeService = kernel.getService(EBikeService.class);
        return ResponseEntity.ok(eBikeService.getUsers().toString());
    }

    @GetMapping("/bikes")
    public ResponseEntity<String> getBikes() {
        EBikeService eBikeService = kernel.getService(EBikeService.class);
        return ResponseEntity.ok(eBikeService.getBikes().toString());
    }

}
