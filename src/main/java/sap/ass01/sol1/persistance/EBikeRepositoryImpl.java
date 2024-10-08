package sap.ass01.sol1.persistance;

import sap.ass01.sol1.service.models.EBike;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class EBikeRepositoryImpl implements EBikeRepository {

    private final Map<String, EBike> eBikes = new HashMap<>();

    @Override
    public void save(EBike eBike) {
        eBikes.put(eBike.getEBikeId(), eBike);
    }

    @Override
    public void delete(String eBikeId) {
        eBikes.remove(eBikeId);
    }

    @Override
    public EBike findById(String eBikeId) {
        return eBikes.get(eBikeId);
    }

    @Override
    public List<EBike> findAll() {
        return List.copyOf(eBikes.values());
    }

}
