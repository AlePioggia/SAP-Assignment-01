package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.domain.repositories.EBikeRepository;
import sap.ass01.sol2.kernel.services.EBikeServicePlugin;

public class UpdateEBikeUseCase {
    private final EBikeServicePlugin eBikeServicePlugin;

    public UpdateEBikeUseCase(EBikeServicePlugin eBikeServicePlugin) {
        this.eBikeServicePlugin = eBikeServicePlugin;
    }

    public void execute(EBike updatedEBike) {
        this.eBikeServicePlugin.updateEBike(updatedEBike);
    }
}
