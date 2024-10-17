package sap.ass01.sol2.usecases.simulation;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.models.Ride;
import sap.ass01.sol2.domain.models.User;
import sap.ass01.sol2.domain.repositories.EBikeRepository;
import sap.ass01.sol2.domain.repositories.UserRepository;

public class RideSimulation extends Thread {

    private final Ride ride;
    private final User user;
    private final EBikeRepository eBikeRepository;
    private final UserRepository userRepository;
    private volatile boolean stopped;

    public RideSimulation(Ride ride, User user, EBikeRepository eBikeRepository, UserRepository userRepository) {
        this.ride = ride;
        this.user = user;
        this.eBikeRepository = eBikeRepository;
        this.userRepository = userRepository;
        this.stopped = false;
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
        var eBike = ride.getEBike();
        eBikeRepository.save(eBike);
        userRepository.save(user);
    }

    public void stopSimulation() {
        stopped = true;
        interrupt();
    }
}
