package sap.ass01.sol1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sap.ass01.sol1.service.models.EBike;
import sap.ass01.sol1.service.models.User;

@Service
public interface EBikeService {

    void addEBike(String eBikeId, String userId, int x, int y);

    EBike getEBike(String eBikeId);

    void updateEBike(EBike eBike);

    void removeEBike(String eBikeId);

    void startRide(String userId, String bikeId);

    List<EBike> getBikes();
}
