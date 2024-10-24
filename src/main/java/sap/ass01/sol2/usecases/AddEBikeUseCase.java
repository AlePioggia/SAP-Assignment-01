package sap.ass01.sol2.usecases;

import sap.ass01.sol2.kernel.services.EBikeServicePlugin;

public class AddEBikeUseCase {
    private final EBikeServicePlugin eBikeServicePlugin;

    public AddEBikeUseCase(EBikeServicePlugin eBikeServicePlugin) {
        this.eBikeServicePlugin = eBikeServicePlugin;
    }

    public void execute(String eBikeId, String userId, int x, int y) {
        this.eBikeServicePlugin.addEBike(eBikeId, userId, x, y);
    }
}
