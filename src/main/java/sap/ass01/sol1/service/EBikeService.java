package sap.ass01.sol1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sap.ass01.sol1.service.models.EBike;
import sap.ass01.sol1.service.models.User;

@Service
public interface EBikeService {

    void addUser(String userId);

    void addEBike(String eBikeId, String userId, int x, int y);

    void removeEBike(String eBikeId);

    void removeUser(String userId);

    void startRide(String userId, String bikeId);

    List<User> getUsers();

    List<EBike> getBikes();
}
