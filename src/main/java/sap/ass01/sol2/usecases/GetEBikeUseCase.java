package sap.ass01.sol2.usecases;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.kernel.services.EBikeServicePlugin;

public class GetEBikeUseCase {
    private final EBikeServicePlugin eBikeServicePlugin;

    public GetEBikeUseCase(EBikeServicePlugin eBikeServicePlugin) {
        this.eBikeServicePlugin = eBikeServicePlugin;
    }

    public EBike execute(String eBikeId) {
        return eBikeServicePlugin.getEBike(eBikeId);
    }
}
