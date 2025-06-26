package lt.caeli.veryNiceApp.nice.service;

import lt.caeli.veryNiceApp.nice.model.CarMaster;
import lt.caeli.veryNiceApp.nice.model.Category;
import lt.caeli.veryNiceApp.nice.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
