package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.Ride;
import sap.ass01.sol2.domain.models.User;
import sap.ass01.sol2.domain.repositories.RideRepository;
import sap.ass01.sol2.domain.repositories.UserRepository;
import sap.ass01.sol2.usecases.simulation.RideSimulation;

public class StopRideUseCase {
    private final RideRepository rideRepository;
    private final UserRepository userRepository;

    public StopRideUseCase(RideRepository rideRepository, UserRepository userRepository) {
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
    }

    public void execute(String rideId) {
        Ride ride = rideRepository.findById(rideId);
        if (ride == null) {
            throw new IllegalArgumentException("Ride not found");
        }

        User user = userRepository.findById(ride.getUser().getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        RideSimulation rideSimulation = ride.getRideSimulation();
        if (rideSimulation != null) {
            rideSimulation.stopSimulation();
        }

        ride.getEBike().markAsAvailable();

        rideRepository.save(ride);
        userRepository.save(user);
    }
}
