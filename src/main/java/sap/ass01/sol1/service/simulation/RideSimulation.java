package sap.ass01.sol1.service.simulation;

import sap.ass01.sol1.service.EBikeService;
import sap.ass01.sol1.service.models.EBike;
import sap.ass01.sol1.service.models.User;

public class RideSimulation extends Thread {

    private Ride ride;
    private User user;
    private volatile boolean stopped;
    private EBikeService bikeService;

    public RideSimulation(Ride ride, User user, EBikeService bikeService) {
        this.ride = ride;
        this.user = user;
        this.bikeService = bikeService;
        stopped = false;
    }

    @Override
    public void run() {
        var eBike = ride.getEBike();
        eBike.updateSpeed(1);

        long lastTimeDecreasedCredit = System.currentTimeMillis();
        synchronized (user) {
            user.deductCredit(1);
        }

        while (!stopped) {
            synchronized (eBike) {
                updatePosition(eBike);
            }

            if (System.currentTimeMillis() - lastTimeDecreasedCredit > 1000) {
                synchronized (user) {
                    user.deductCredit(1);
                }
                lastTimeDecreasedCredit = System.currentTimeMillis();
            }

            saveStatePeriodically();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void updatePosition(EBike eBike) {
        var location = eBike.getLocation();
        var direction = eBike.getDirection();
        var speed = eBike.getSpeed();

        eBike.updateLocation(location.sum(direction.mul(speed)));
    }

    private void saveStatePeriodically() {
        var ebike = ride.getEBike();
        bikeService.updateEBike(ebike);
        bikeService.updateUser(user);
    }

    public void stopSimulation() {
        stopped = true;
        interrupt();
    }
}