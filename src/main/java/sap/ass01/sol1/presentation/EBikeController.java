package sap.ass01.sol1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sap.ass01.sol1.kernel.Kernel;
import sap.ass01.sol1.service.plugins.EBikeServicePlugin;

@RestController
@RequestMapping("/api")
public class EBikeController {

    private final Kernel kernel;

    @Autowired
    public EBikeController(Kernel kernel) {
        this.kernel = kernel;
    }

    @PostMapping("add")
    public ResponseEntity<String> addEBike(@RequestParam String eBikeId, @RequestParam String userId,
            @RequestParam int x, @RequestParam int y) {
        EBikeServicePlugin eBikeService = kernel.getService(EBikeServicePlugin.class);
        eBikeService.addEBike(eBikeId, userId, x, y);
        return ResponseEntity.ok("EBike added");
    }

    @PostMapping("remove")
    public ResponseEntity<String> removeEBike(@RequestParam String eBikeId) {
        EBikeServicePlugin eBikeService = kernel.getService(EBikeServicePlugin.class);
        eBikeService.removeEBike(eBikeId);
        return ResponseEntity.ok("EBike removed");
    }

    @GetMapping("")
    public ResponseEntity<String> getBikes() {
        EBikeServicePlugin eBikeService = kernel.getService(EBikeServicePlugin.class);
        return ResponseEntity.ok(eBikeService.getBikes().toString());
    }

}
