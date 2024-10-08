package sap.ass01.sol1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sap.ass01.sol1.persistance.UserRepository;

import sap.ass01.sol1.persistance.EBikeRepository;
import sap.ass01.sol1.service.models.EBikeImpl;
import sap.ass01.sol1.service.models.User;
import sap.ass01.sol1.service.models.UserImpl;
import sap.ass01.sol1.service.models.UserImpl.Role;
import sap.ass01.sol1.service.utils.Position;
import sap.ass01.sol1.service.models.*;

@Service
public class EBikeServiceImpl implements EBikeService {

    private final UserRepository userRepository;
    private final EBikeRepository eBikeRepository;

    @Autowired
    public EBikeServiceImpl(UserRepository userRepository, EBikeRepository eBikeRepository) {
        this.userRepository = userRepository;
        this.eBikeRepository = eBikeRepository;
    }

    @Override
    public void addUser(String userId) {
        User user = new UserImpl(userId, 0, Role.USER);
        System.out.println("user added in repository");
        userRepository.save(user);
    }

    @Override
    public void addEBike(String eBikeId, String userId, int x, int y) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        EBike eBike = new EBikeImpl(eBikeId, new Position(x, y));
        eBikeRepository.save(eBike);
    }

    @Override
    public void removeEBike(String eBikeId) {
        eBikeRepository.delete(eBikeId);
    }

    @Override
    public void removeUser(String userId) {
        userRepository.delete(userId);
    }

    @Override
    public void startRide(String userId, String bikeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startRide'");
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<EBike> getBikes() {
        return eBikeRepository.findAll();
    }

}
