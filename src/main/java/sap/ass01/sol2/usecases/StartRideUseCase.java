package sap.ass01.sol2.usecases;

import sap.ass01.sol2.kernel.services.RideServicePlugin;

public class StartRideUseCase {

    private final RideServicePlugin rideServicePlugin;

    public StartRideUseCase(RideServicePlugin rideServicePlugin) {
        this.rideServicePlugin = rideServicePlugin;
    }

    public void execute(String userId, String bikeId) {
        this.rideServicePlugin.startRide(userId, bikeId);
    }
}
