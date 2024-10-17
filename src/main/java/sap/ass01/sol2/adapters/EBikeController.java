package sap.ass01.sol2.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sap.ass01.sol2.usecases.AddEBikeUseCase;
import sap.ass01.sol2.usecases.GetAllEBikesUseCase;
import sap.ass01.sol2.usecases.RemoveEBikeUseCase;

@RestController
@RequestMapping("/api/ebikes")
public class EBikeController {

    private final AddEBikeUseCase addEBikeUseCase;
    private final RemoveEBikeUseCase removeEBikeUseCase;
    private final GetAllEBikesUseCase getBikesUseCase;

    @Autowired
    public EBikeController(AddEBikeUseCase addEBikeUseCase,
            RemoveEBikeUseCase removeEBikeUseCase,
            GetAllEBikesUseCase getBikesUseCase) {
        this.addEBikeUseCase = addEBikeUseCase;
        this.removeEBikeUseCase = removeEBikeUseCase;
        this.getBikesUseCase = getBikesUseCase;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEBike(@RequestParam String eBikeId,
            @RequestParam String userId,
            @RequestParam int x,
            @RequestParam int y) {
        addEBikeUseCase.execute(eBikeId, userId, x, y);
        return ResponseEntity.ok("EBike added");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeEBike(@RequestParam String eBikeId) {
        removeEBikeUseCase.execute(eBikeId);
        return ResponseEntity.ok("EBike removed");
    }

    @GetMapping
    public ResponseEntity<String> getBikes() {
        return ResponseEntity.ok(getBikesUseCase.execute().toString());
    }
}
