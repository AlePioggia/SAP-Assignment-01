package sap.ass01.sol2.usecases;

import java.util.List;

import sap.ass01.sol2.domain.models.EBike;
import sap.ass01.sol2.kernel.services.EBikeServicePlugin;

public class GetAllEBikesUseCase {
    private final EBikeServicePlugin eBikeServicePlugin;

    public GetAllEBikesUseCase(EBikeServicePlugin eBikeServicePlugin) {
        this.eBikeServicePlugin = eBikeServicePlugin;
    }

    public List<EBike> execute() {
        return eBikeServicePlugin.getAll();
    }
}
