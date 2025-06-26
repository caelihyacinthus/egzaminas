package lt.caeli.veryNiceApp.nice.dto.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lt.caeli.veryNiceApp.nice.model.Category;
import lt.caeli.veryNiceApp.nice.model.Review;

import java.time.LocalDate;
import java.util.List;

public record UpdateCarMasterRequestDTO(long id,
                                        @NotEmpty
                                        @Size(min = 2, max = 100, message = "Maximum 100 characters and at least 2")
                                        String name,
                                        List<Review> reviews,
                                        @NotEmpty(message = "Book must have at least one category")
                                        List<Category> categories) {
}
