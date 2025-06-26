package lt.caeli.veryNiceApp.nice.dto.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lt.caeli.veryNiceApp.nice.model.Category;
import lt.caeli.veryNiceApp.nice.model.Review;

import java.time.LocalDate;
import java.util.List;

public record UpdateBookRequestDTO(long id,
                                   @NotEmpty
                                   @Size(min = 2, max = 150, message = "Maximum 150 characters and at least 2")
                                   String title,
                                   @NotEmpty
                                   @Size(max = 150, message = "Maxing 150 characters")
                                   @Pattern(regexp = "^[A-Z][a-z] +$", message = "Must start with uppercase letter, and continue as lowercase")
                                   String author,
                                   @NotEmpty
                                   String isbn,
                                   @Size(max = 65_535)
                                   String description,
                                   @Size(max = 150)
                                   String imageUrl,
                                   @Size(max = 30_000)
                                   int pageCount,
                                   @PastOrPresent
                                   LocalDate publishDate,
                                   List<Review> reviews,
                                   @NotEmpty(message = "Book must have at least one category")
                                   List<Category> categories) {
}
