package lt.caeli.veryNiceApp.nice.dto.book;


import lt.caeli.veryNiceApp.nice.model.Category;

import java.time.LocalDate;
import java.util.List;

public record CreateCarMasterResponseDTO(long id,
                                         String name,
                                         List<Category> categories) {
}
