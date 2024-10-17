package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.models.EBikeImpl;
import sap.ass01.sol2.domain.repositories.EBikeRepository;
import sap.ass01.sol2.domain.utils.Position;

public class AddEBikeUseCase {
    private final EBikeRepository eBikeRepository;

    public AddEBikeUseCase(EBikeRepository eBikeRepository) {
        this.eBikeRepository = eBikeRepository;
    }

    public void execute(String eBikeId, String userId, int x, int y) {
        EBike newEBike = new EBikeImpl(eBikeId, new Position(x, y), 0, null);
        eBikeRepository.save(newEBike);
    }
}
