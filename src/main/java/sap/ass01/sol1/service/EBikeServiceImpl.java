package sap.ass01.sol1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sap.ass01.sol1.persistance.EBikeRepository;
import sap.ass01.sol1.service.utils.Position;
import sap.ass01.sol1.service.models.*;
import sap.ass01.sol1.service.plugins.EBikeServicePlugin;
import sap.ass01.sol1.service.plugins.UserServicePlugin;

@Service
public class EBikeServiceImpl implements EBikeServicePlugin {

    private final EBikeRepository eBikeRepository;
    private final UserServicePlugin userService;

    @Autowired
    public EBikeServiceImpl(UserServicePlugin userService, EBikeRepository eBikeRepository) {
        this.userService = userService;
        this.eBikeRepository = eBikeRepository;
    }

    @Override
    public void addEBike(String eBikeId, String userId, int x, int y) {
        User user = userService.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        EBike eBike = new EBikeImpl(eBikeId, new Position(x, y), 1, null);
        eBikeRepository.save(eBike);
    }

    @Override
    public EBike getEBike(String eBikeId) {
        return eBikeRepository.findById(eBikeId);
    }

    @Override
    public void removeEBike(String eBikeId) {
        eBikeRepository.delete(eBikeId);
    }

    @Override
    public List<EBike> getBikes() {
        return eBikeRepository.findAll();
    }

    @Override
    public void updateEBike(EBike eBike) {
        if (eBike == null || eBikeRepository.findById(eBike.getEBikeId()) == null) {
            throw new IllegalArgumentException("EBike not found");
        }
        eBikeRepository.save(eBike);
    }

    @Override
    public void initialize() {
    }

    @Override
    public String getName() {
        return "EBikeService";
    }
}
