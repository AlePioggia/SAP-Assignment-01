package sap.ass01.sol2.kernel.services;

import sap.ass01.sol2.domain.models.EBike;
import java.util.List;

public interface EBikeServicePlugin {
    public void addEBike(String eBikeId, String userId, int x, int y);

    public List<EBike> getAll();

    public EBike getEBike(String eBikeId);

    public void removeEBike(String eBikeId);

    public void updateEBike(EBike eBike);
}
