package sap.ass01.sol2.domain.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import sap.ass01.sol2.domain.models.EBike;

@Repository
public interface EBikeRepository {
    void save(EBike eBike);

    void delete(String eBikeId);

    EBike findById(String eBikeId);

    List<EBike> findAll();
}
