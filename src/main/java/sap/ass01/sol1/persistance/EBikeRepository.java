package sap.ass01.sol1.persistance;

import sap.ass01.sol1.service.models.EBike;
import java.util.List;

public interface EBikeRepository {
    void save(EBike eBike);

    void delete(String eBikeId);

    EBike findById(String eBikeId);

    List<EBike> findAll();
}
