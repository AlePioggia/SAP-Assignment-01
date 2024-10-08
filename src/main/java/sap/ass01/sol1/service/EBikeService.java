package sap.ass01.sol1.service;

public interface EBikeService {

    void addUser(String userId, int x, int y);

    void addEBike(String eBikeId, String userId, int x, int y);

    void removeEBike(String eBikeId);

    void removeUser(String userId);

    void startRide(String userId, String bikeId);

}
