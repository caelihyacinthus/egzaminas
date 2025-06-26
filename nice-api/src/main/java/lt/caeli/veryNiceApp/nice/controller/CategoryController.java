package lt.caeli.veryNiceApp.nice.controller;

import lt.caeli.veryNiceApp.nice.dto.category.CategoryMapper;
import lt.caeli.veryNiceApp.nice.dto.category.GetCategoryResponseDTO;
import lt.caeli.veryNiceApp.nice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
