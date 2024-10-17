package sap.ass01.sol2.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sap.ass01.sol2.usecases.StartRideUseCase;
import sap.ass01.sol2.usecases.StopRideUseCase;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final StartRideUseCase startRideUseCase;
    private final StopRideUseCase stopRideUseCase;

    @Autowired
    public RideController(StartRideUseCase startRideUseCase,
            StopRideUseCase stopRideUseCase) {
        this.startRideUseCase = startRideUseCase;
        this.stopRideUseCase = stopRideUseCase;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startRide(@RequestParam String userId,
            @RequestParam String bikeId) {
        startRideUseCase.execute(userId, bikeId);
        return ResponseEntity.ok("Ride started");
    }

    @PostMapping("/end/{rideId}")
    public ResponseEntity<String> endRide(@PathVariable String rideId) {
        stopRideUseCase.execute(rideId);
        return ResponseEntity.ok("Ride ended");
    }

}
