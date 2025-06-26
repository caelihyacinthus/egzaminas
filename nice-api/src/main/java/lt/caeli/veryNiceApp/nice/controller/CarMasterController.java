package lt.caeli.veryNiceApp.nice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lt.caeli.veryNiceApp.nice.dto.book.*;
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

    private final CarMasterService carMasterService;

    @Autowired
    public CarMasterController(CarMasterService carMasterService) {
        this.carMasterService = carMasterService;
    }

    @GetMapping("/master")
    public ResponseEntity<List<GetPartialCarMasterResponseDTO>> getBooks(@RequestParam(defaultValue = "10") @Min(value = 1) int size, @RequestParam(defaultValue = "1") @Min(value = 1) int page) {
        return ResponseEntity.ok(carMasterService.findAllCarMasterPage(size, page)
            .stream()
            .map(CarMasterMapper::toGetPartialCarMasterResponseDTO)
            .toList()
        );
    }

    @GetMapping("/master/{id}")
    public ResponseEntity<GetCarMasterResponseDTO> getBook(@PathVariable long id) {
        Optional<CarMaster> maybeBook = carMasterService.findCarMasterById(id);

        if (maybeBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(CarMasterMapper.toGetCarMasterResponseDTO(maybeBook.get()));
    }

    @PostMapping("/master")
    public ResponseEntity<CreateCarMasterResponseDTO> addBook(@Valid @RequestBody CreateCarMasterRequestDTO createBookRequestDTO) {
        CarMaster savedCarMaster = carMasterService.saveCarMaster(CarMasterMapper.toCarMaster(createBookRequestDTO));

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedCarMaster.getId())
                    .toUri())
            .body(CarMasterMapper.toCreateCarMasterResponseDTO(savedCarMaster));
    }

    @PutMapping("/master/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody UpdateCarMasterRequestDTO updateBookRequestDTO) {
        if (carMasterService.existsCarMasterById(id)) {
            CarMaster carMasterFromDb = carMasterService.findCarMasterById(id).get();
            CarMaster savedCarMaster = carMasterService.saveCarMaster(carMasterFromDb);

            return ResponseEntity.ok(CarMasterMapper.toUpdateCarMasterResponseDTO(savedCarMaster));
        }

        CarMaster savedCarMaster = carMasterService.saveCarMaster(CarMasterMapper.toCarMaster(updateBookRequestDTO));

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                    .replacePath("/api/master/{id}")
                    .buildAndExpand(savedCarMaster.getId())
                    .toUri())
            .body(CarMasterMapper.toUpdateCarMasterResponseDTO(savedCarMaster));
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