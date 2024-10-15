package sap.ass01.sol1.persistance;

import sap.ass01.sol1.service.simulation.Ride;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository {
    void save(Ride ride);

    void delete(String rideId);

    Ride findById(String rideId);

    List<Ride> findAll();

    List<Ride> findActiveRides();
}