package sap.ass01.sol1.service.plugins;

import java.util.List;

import org.springframework.stereotype.Service;

import sap.ass01.sol1.kernel.Plugin;
import sap.ass01.sol1.service.models.EBike;

@Service
public interface EBikeServicePlugin extends Plugin {

    void addEBike(String eBikeId, String userId, int x, int y);

    EBike getEBike(String eBikeId);

    void updateEBike(EBike eBike);

    void removeEBike(String eBikeId);

    List<EBike> getBikes();
}
