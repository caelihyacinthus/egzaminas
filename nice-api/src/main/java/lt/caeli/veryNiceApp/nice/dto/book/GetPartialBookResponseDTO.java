package lt.caeli.veryNiceApp.nice.dto.book;

import lt.caeli.veryNiceApp.nice.model.Category;

import java.time.LocalDate;
import java.util.List;

public record GetPartialBookResponseDTO(long id,
                                        String title,
                                        String author,
                                        String imageUrl,
                                        LocalDate publishDate,
                                        List<Category> categories) {
}
