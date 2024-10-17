package sap.ass01.sol2.domain.repositories;

import sap.ass01.sol2.domain.models.Ride;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class RideRepositoryImpl implements RideRepository {

    private final Map<String, Ride> rides = new HashMap<>();

    @Override
    public void save(Ride ride) {
        rides.put(ride.getRideId(), ride);
    }

    @Override
    public void delete(String rideId) {
        rides.remove(rideId);
    }

    @Override
    public Ride findById(String rideId) {
        return rides.get(rideId);
    }

    @Override
    public List<Ride> findAll() {
        return List.copyOf(rides.values());
    }

    @Override
    public List<Ride> findActiveRides() {
        return rides.values().stream()
                .filter(ride -> ride.getEndTime() == null)
                .collect(Collectors.toList());
    }
}
