// src/main/java/sap/ass01/sol2/kernel/services/RideServicePluginImpl.java
package sap.ass01.sol2.kernel.services;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.models.Ride;
import sap.ass01.sol2.domain.models.User;
import sap.ass01.sol2.domain.repositories.EBikeRepository;
import sap.ass01.sol2.domain.repositories.RideRepository;
import sap.ass01.sol2.domain.repositories.UserRepository;

public class RideServicePluginImpl implements RideServicePlugin {
    private final EBikeRepository eBikeRepository;
    private final UserRepository userRepository;
    private final RideRepository rideRepository;

    public RideServicePluginImpl(EBikeRepository eBikeRepository, UserRepository userRepository,
            RideRepository rideRepository) {
        this.eBikeRepository = eBikeRepository;
        this.userRepository = userRepository;
        this.rideRepository = rideRepository;
    }

    @Override
    public void startRide(String userId, String bikeId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        EBike eBike = eBikeRepository.findById(bikeId);
        if (eBike == null || !eBike.isAvailable()) {
            throw new IllegalArgumentException("EBike not found or unavailable");
        }

        eBike.markAsUnavailable();
        eBikeRepository.save(eBike);

        Ride ride = new Ride("0", user, eBike);
        rideRepository.save(ride);
    }

    @Override
    public void stopRide(String rideId) {
        Ride ride = rideRepository.findById(rideId);
        if (ride == null) {
            throw new IllegalArgumentException("Ride not found");
        }

        User user = userRepository.findById(ride.getUser().getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        ride.getEBike().markAsAvailable();
        rideRepository.save(ride);
        userRepository.save(user);
    }
}
