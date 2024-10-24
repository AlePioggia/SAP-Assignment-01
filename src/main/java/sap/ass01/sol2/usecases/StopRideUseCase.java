package sap.ass01.sol2.usecases;

import sap.ass01.sol2.kernel.services.RideServicePlugin;

public class StopRideUseCase {
    private final RideServicePlugin rideServicePlugin;

    public StopRideUseCase(RideServicePlugin rideServicePlugin) {
        this.rideServicePlugin = rideServicePlugin;
    }

    public void execute(String rideId) {
        this.rideServicePlugin.stopRide(rideId);
    }
}
