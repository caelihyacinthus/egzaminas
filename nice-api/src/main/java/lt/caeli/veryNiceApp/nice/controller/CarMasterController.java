package lt.caeli.veryNiceApp.nice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lt.caeli.veryNiceApp.nice.dto.CarMasterMapper;
import lt.caeli.veryNiceApp.nice.dto.RequestCarMasterDTO;
import lt.caeli.veryNiceApp.nice.model.CarMaster;
import lt.caeli.veryNiceApp.nice.service.CarMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarMasterController {
    public CarMasterService carMasterService;

    @Autowired
    public CarMasterController(CarMasterService carMasterService) {
        this.carMasterService = carMasterService;
    }

//    @GetMapping("/master")
//    public ResponseEntity<List<CarMaster>> getAllMaster() {
//        return ResponseEntity.ok(carMasterService.findAllCarMasters());
//    }

    @GetMapping("/master/{id}")
    public ResponseEntity<CarMaster> getMaster(@PathVariable long id) {
        Optional<CarMaster> carOp = carMasterService.findCarMasterById(id);

        return carOp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @GetMapping("/master")
    public ResponseEntity<List<CarMaster>> getAllMasterPage(@RequestParam(defaultValue = "12") @Min(value = 1) int size, @RequestParam(defaultValue = "1") @Min(value = 1) int page) {
        return ResponseEntity.ok(carMasterService.findAllCarMasterPage(size, page)
            .stream()
            .toList()
        );
    }

    @PostMapping("/master")
    public ResponseEntity<CarMaster> addBook(@Valid @RequestBody RequestCarMasterDTO carMasterDTO) {
        CarMaster carMasterNew = carMasterService.saveCarMaster(CarMasterMapper.toCarMaster(carMasterDTO));

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(carMasterNew.getId())
                    .toUri())
            .body(carMasterNew);
    }

    @DeleteMapping("/master/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        if (!carMasterService.existsCarMasterById(id)) {
            return ResponseEntity.notFound().build();
        }

        carMasterService.deleteCarMasterById(id);

        return ResponseEntity.noContent().build();
    }

}
