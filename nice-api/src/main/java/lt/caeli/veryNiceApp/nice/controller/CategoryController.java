package lt.caeli.veryNiceApp.nice.controller;

import jakarta.validation.constraints.Min;
import lt.caeli.veryNiceApp.nice.dto.book.CarMasterMapper;
import lt.caeli.veryNiceApp.nice.dto.book.GetPartialCarMasterResponseDTO;
import lt.caeli.veryNiceApp.nice.dto.book.UpdateCarMasterRequestDTO;
import lt.caeli.veryNiceApp.nice.dto.category.CategoryMapper;
import lt.caeli.veryNiceApp.nice.dto.category.GetCategoryResponseDTO;
import lt.caeli.veryNiceApp.nice.model.CarMaster;
import lt.caeli.veryNiceApp.nice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<GetCategoryResponseDTO>> getCategories() {
        return ResponseEntity.ok(categoryService.findAllCategories()
            .stream()
            .map(CategoryMapper::toGetCategoryResponseDTO)
            .toList()
        );
    }

    @PutMapping("/categories")
    public ResponseEntity<?> updateCategories() {
        return null;
    }

//    @PutMapping("/master/{id}")
//    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody UpdateCarMasterRequestDTO updateBookRequestDTO) {
//        if (carMasterService.existsCarMasterById(id)) {
//            CarMaster carMasterFromDb = carMasterService.findCarMasterById(id).get();
//            CarMaster savedCarMaster = carMasterService.saveCarMaster(carMasterFromDb);
//
//            return ResponseEntity.ok(CarMasterMapper.toUpdateCarMasterResponseDTO(savedCarMaster));
//        }
//
//        CarMaster savedCarMaster = carMasterService.saveCarMaster(CarMasterMapper.toCarMaster(updateBookRequestDTO));
//
//        return ResponseEntity.created(
//                ServletUriComponentsBuilder.fromCurrentRequest()
//                    .replacePath("/api/master/{id}")
//                    .buildAndExpand(savedCarMaster.getId())
//                    .toUri())
//            .body(CarMasterMapper.toUpdateCarMasterResponseDTO(savedCarMaster));
//    }
//
//    @DeleteMapping("/master/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
//        if (!carMasterService.existsCarMasterById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        carMasterService.deleteCarMasterById(id);
//
//        return ResponseEntity.noContent().build();
//    }
}
