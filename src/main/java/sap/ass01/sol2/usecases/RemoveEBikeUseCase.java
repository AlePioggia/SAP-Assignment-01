package sap.ass01.sol2.usecases;

import sap.ass01.sol2.kernel.services.EBikeServicePlugin;

public class RemoveEBikeUseCase {
    private final EBikeServicePlugin eBikeServicePlugin;

    public RemoveEBikeUseCase(EBikeServicePlugin eBikeServicePlugin) {
        this.eBikeServicePlugin = eBikeServicePlugin;
    }

    public void execute(String eBikeId) {
        this.eBikeServicePlugin.removeEBike(eBikeId);
    }
}
