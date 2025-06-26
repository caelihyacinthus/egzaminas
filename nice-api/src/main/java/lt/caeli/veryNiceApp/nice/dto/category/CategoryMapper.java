package lt.caeli.veryNiceApp.nice.dto.category;


import lt.caeli.veryNiceApp.nice.model.Category;

public class CategoryMapper {

    public static GetCategoryResponseDTO toGetCategoryResponseDTO(Category category) {
        return new GetCategoryResponseDTO(
            category.getId(),
            category.getName()
        );
    }
}
