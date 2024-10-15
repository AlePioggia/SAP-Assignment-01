package sap.ass01.sol1.service.plugins;

import sap.ass01.sol1.kernel.Plugin;
import sap.ass01.sol1.service.simulation.Ride;
import java.util.List;

public interface RideServicePlugin extends Plugin {

    void startRide(String userId, String bikeId);

    void endRide(String rideId);

    List<Ride> getActiveRides();
}
