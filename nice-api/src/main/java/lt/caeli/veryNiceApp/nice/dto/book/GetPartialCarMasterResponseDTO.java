package lt.caeli.veryNiceApp.nice.dto.book;

import lt.caeli.veryNiceApp.nice.model.Category;

import java.util.List;

public record GetPartialCarMasterResponseDTO(long id,
                                             String name,
                                             List<Category> categories) {
}
