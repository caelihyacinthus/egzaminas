package lt.caeli.veryNiceApp.nice.dto.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lt.caeli.veryNiceApp.nice.model.Category;

import java.util.List;

public record CreateCarMasterRequestDTO(long id,
                                        @NotEmpty
                                        @Size(min = 2, max = 150, message = "Maximum 150 characters and at least 2")
                                        String name,
                                        @NotEmpty
                                        @Size(max = 150, message = "Maxing 150 characters")
                                        @Pattern(regexp = "^[A-Z][a-z] +$", message = "Must start with uppercase letter, and continue as lowercase")
                                        @NotEmpty(message = "Book must have at least one category")
                                        List<Category> categories) {
}
