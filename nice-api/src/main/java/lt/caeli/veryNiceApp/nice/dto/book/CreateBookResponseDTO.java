package lt.caeli.veryNiceApp.nice.dto.book;


import lt.caeli.veryNiceApp.nice.model.Category;

import java.time.LocalDate;
import java.util.List;

public record CreateBookResponseDTO(long id,
                                    String title,
                                    String author,
                                    String isbn,
                                    String description,
                                    String imageUrl,
                                    int pageCount,
                                    LocalDate publishDate,
                                    List<Category> categories) {
}
