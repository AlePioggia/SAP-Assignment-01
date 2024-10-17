package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.models.Ride;
import sap.ass01.sol2.domain.models.User;
import sap.ass01.sol2.domain.repositories.EBikeRepository;
import sap.ass01.sol2.domain.repositories.UserRepository;
import sap.ass01.sol2.usecases.simulation.RideSimulation;

public class StartRideUseCase {

    private final EBikeRepository eBikeRepository;
    private final UserRepository userRepository;

    public StartRideUseCase(EBikeRepository eBikeRepository, UserRepository userRepository) {
        this.eBikeRepository = eBikeRepository;
        this.userRepository = userRepository;
    }

    public void execute(String userId, String bikeId) {
        User user = userRepository.findById(userId);
        EBike eBike = eBikeRepository.findById(bikeId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (eBike == null || !eBike.isAvailable()) {
            throw new IllegalArgumentException("EBike not found or unavailable");
        }

        eBike.markAsUnavailable();
        eBikeRepository.save(eBike);

        Ride ride = new Ride("0", user, eBike);

        RideSimulation rideSimulation = new RideSimulation(ride, user,
                eBikeRepository, userRepository);

        ride.setRideSimulation(rideSimulation);
        rideSimulation.start();
    }
}
