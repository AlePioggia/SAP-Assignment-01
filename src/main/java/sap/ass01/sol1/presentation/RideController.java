package sap.ass01.sol1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sap.ass01.sol1.kernel.Kernel;
import sap.ass01.sol1.service.RideServicePlugin;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideServicePlugin rideService;

    @Autowired
    public RideController(Kernel kernel) {
        this.rideService = kernel.getService(RideServicePlugin.class);
    }

    @PostMapping("/start")
    public ResponseEntity<String> startRide(@RequestParam String userId,
            @RequestParam String bikeId) {
        this.rideService.startRide(userId, bikeId);
        return ResponseEntity.ok("Ride started");
    }

    @PostMapping("/end/{rideId}")
    public ResponseEntity<String> endRide(@PathVariable String rideId) {
        this.rideService.endRide(rideId);
        return ResponseEntity.ok("Ride ended");
    }

    @GetMapping
    public ResponseEntity<String> getActiveRides() {
        return ResponseEntity.ok(this.rideService.getActiveRides().toString());
    }
}
