package sap.ass01.sol2.domain.repositories;

import sap.ass01.sol2.domain.models.Ride;
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