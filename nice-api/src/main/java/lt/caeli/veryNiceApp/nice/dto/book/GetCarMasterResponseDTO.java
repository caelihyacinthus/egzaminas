package lt.caeli.veryNiceApp.nice.dto.book;

import lt.caeli.veryNiceApp.nice.model.Category;
import lt.caeli.veryNiceApp.nice.model.Review;

import java.util.List;

public record GetCarMasterResponseDTO(long id,
                                      String name,
                                      List<Category> categories,
                                      List<Review> reviews) {
}
