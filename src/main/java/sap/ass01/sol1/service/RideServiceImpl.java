package sap.ass01.sol1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;

import sap.ass01.sol1.persistance.RideRepository;
import sap.ass01.sol1.service.models.EBike;
import sap.ass01.sol1.service.models.User;
import sap.ass01.sol1.service.plugins.EBikeServicePlugin;
import sap.ass01.sol1.service.plugins.RideServicePlugin;
import sap.ass01.sol1.service.plugins.UserServicePlugin;
import sap.ass01.sol1.service.simulation.Ride;
import sap.ass01.sol1.service.simulation.RideSimulation;

import java.util.UUID;

public class RideServiceImpl implements RideServicePlugin {

    private final RideRepository rideRepository;
    private final UserServicePlugin userService;

    private final EBikeServicePlugin eBikeService;

    @Autowired
    public RideServiceImpl(RideRepository rideRepository, UserServicePlugin userService,
            EBikeServicePlugin eBikeService) {
        this.rideRepository = rideRepository;
        this.userService = userService;
        this.eBikeService = eBikeService;
    }

    @Override
    public void startRide(String userId, String bikeId) {
        User user = userService.getUser(userId);
        EBike eBike = eBikeService.getEBike(bikeId);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (eBike == null || !eBike.isAvailable()) {
            throw new IllegalArgumentException("EBike not available");
        }

        eBike.markAsUnavailable();
        eBikeService.updateEBike(eBike);

        String rideId = UUID.randomUUID().toString();
        Ride ride = new Ride(rideId, user, eBike);
        rideRepository.save(ride);

        RideSimulation rideSimulation = new RideSimulation(ride, user, eBikeService, userService);
        rideSimulation.start();
    }

    @Override
    public void endRide(String rideId) {
        Ride ride = rideRepository.findById(rideId);
        if (ride == null) {
            throw new IllegalArgumentException("Ride not found");
        }

        ride.endRide();
        rideRepository.save(ride);

        EBike eBike = ride.getEBike();
        eBike.markAsAvailable();
        eBikeService.updateEBike(eBike);
    }

    @Override
    public List<Ride> getActiveRides() {
        return rideRepository.findAll()
                .stream()
                .filter(ride -> ride.getEndTime() == null)
                .collect(Collectors.toList());
    }

    @Override
    public void initialize() {
    }

    @Override
    public String getName() {
        return "RideService";
    }

}
