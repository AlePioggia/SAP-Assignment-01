package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.repositories.EBikeRepository;

public class GetEBikeUseCase {
    private final EBikeRepository eBikeRepository;

    public GetEBikeUseCase(EBikeRepository eBikeRepository) {
        this.eBikeRepository = eBikeRepository;
    }

    public EBike execute(String eBikeId) {
        return eBikeRepository.findById(eBikeId);
    }
}
