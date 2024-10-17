package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.repositories.EBikeRepository;

public class RemoveEBikeUseCase {
    private final EBikeRepository eBikeRepository;

    public RemoveEBikeUseCase(EBikeRepository eBikeRepository) {
        this.eBikeRepository = eBikeRepository;
    }

    public void execute(String eBikeId) {
        eBikeRepository.delete(eBikeId);
    }
}
