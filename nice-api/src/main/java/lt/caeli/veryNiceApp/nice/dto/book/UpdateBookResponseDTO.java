package lt.caeli.veryNiceApp.nice.dto.book;

import lt.caeli.veryNiceApp.nice.model.Category;
import lt.caeli.veryNiceApp.nice.model.Review;

import java.time.LocalDate;
import java.util.List;

public record UpdateBookResponseDTO(long id,
                                    String title,
                                    String author,
                                    String isbn,
                                    String description,
                                    String imageUrl,
                                    int pageCount,
                                    LocalDate publishDate,
                                    List<Review> reviews,
                                    List<Category> categories) {
}
