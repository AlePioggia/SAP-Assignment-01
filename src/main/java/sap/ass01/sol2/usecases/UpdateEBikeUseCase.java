package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.repositories.EBikeRepository;

public class UpdateEBikeUseCase {
    private final EBikeRepository eBikeRepository;

    public UpdateEBikeUseCase(EBikeRepository eBikeRepository) {
        this.eBikeRepository = eBikeRepository;
    }

    public void execute(EBike updatedEBike) {
        EBike existingEBike = eBikeRepository.findById(updatedEBike.getEBikeId());
        if (existingEBike == null) {
            throw new IllegalArgumentException("EBike not found");
        }

        updatedEBike.setEBikeId(updatedEBike.getEBikeId());
        eBikeRepository.save(updatedEBike);
    }
}
