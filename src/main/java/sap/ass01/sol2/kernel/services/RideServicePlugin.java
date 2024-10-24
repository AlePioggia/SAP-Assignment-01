package sap.ass01.sol2.kernel.services;

public interface RideServicePlugin {
    public void startRide(String userId, String bikeId);

    public void stopRide(String rideId);
}
