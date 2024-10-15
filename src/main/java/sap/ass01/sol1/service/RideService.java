package sap.ass01.sol1.service;

import sap.ass01.sol1.service.simulation.Ride;
import java.util.List;

public interface RideService {

    void startRide(String userId, String bikeId);

    void endRide(String rideId);

    List<Ride> getActiveRides();
}
