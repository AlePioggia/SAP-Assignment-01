// src/main/java/sap/ass01/sol2/kernel/services/EBikeServicePluginImpl.java
package sap.ass01.sol2.kernel.services;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.models.EBikeImpl;
import sap.ass01.sol2.domain.repositories.EBikeRepository;
import sap.ass01.sol2.domain.utils.Position;

import java.util.List;

public class EBikeServicePluginImpl implements EBikeServicePlugin {
    private final EBikeRepository eBikeRepository;

    public EBikeServicePluginImpl(EBikeRepository eBikeRepository) {
        this.eBikeRepository = eBikeRepository;
    }

    @Override
    public void addEBike(String eBikeId, String userId, int x, int y) {
        EBike newEBike = new EBikeImpl(eBikeId, new Position(x, y), 0, null);
        eBikeRepository.save(newEBike);
    }

    @Override
    public List<EBike> getAll() {
        return eBikeRepository.findAll();
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
    public void updateEBike(EBike updatedEBike) {
        EBike existingEBike = eBikeRepository.findById(updatedEBike.getEBikeId());
        if (existingEBike == null) {
            throw new IllegalArgumentException("EBike not found");
        }
        eBikeRepository.save(updatedEBike);
    }
}
