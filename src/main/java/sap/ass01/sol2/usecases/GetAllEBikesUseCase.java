package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.repositories.EBikeRepository;

import java.util.List;

public class GetAllEBikesUseCase {
    private final EBikeRepository eBikeRepository;

    public GetAllEBikesUseCase(EBikeRepository eBikeRepository) {
        this.eBikeRepository = eBikeRepository;
    }

    public List<EBike> execute() {
        return eBikeRepository.findAll();
    }
}
