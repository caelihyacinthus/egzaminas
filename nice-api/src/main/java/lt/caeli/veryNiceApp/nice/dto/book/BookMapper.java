package lt.caeli.veryNiceApp.nice.dto.book;

import lt.caeli.veryNiceApp.nice.model.Book;

import java.util.List;

public class BookMapper {

    public static GetPartialBookResponseDTO toGetPartialBookResponseDTO(Book book) {
        return new GetPartialBookResponseDTO(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            book.getImageUrl(),
            book.getPublishDate(),
            book.getCategories()
        );
    }

    public static CreateBookResponseDTO toCreateBookResponseDTO(Book book) {
        return new CreateBookResponseDTO(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            book.getIsbn(),
            book.getDescription(),
            book.getImageUrl(),
            book.getPageCount(),
            book.getPublishDate(),
            book.getCategories()
        );
    }

    public static GetBookResponseDTO toGetBookResponseDTO(Book book) {
        return new GetBookResponseDTO(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            book.getIsbn(),
            book.getDescription(),
            book.getImageUrl(),
            book.getPageCount(),
            book.getPublishDate(),
            book.getCategories(),
            book.getReviews()
        );
    }

    public static UpdateBookResponseDTO toUpdateBookResponseDTO(Book book) {
        return new UpdateBookResponseDTO(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            book.getIsbn(),
            book.getDescription(),
            book.getImageUrl(),
            book.getPageCount(),
            book.getPublishDate(),
            book.getReviews(),
            book.getCategories()
        );
    }

    public static Book toBook(CreateBookRequestDTO createBookRequestDTO) {
        return new Book(
            createBookRequestDTO.title(),
            createBookRequestDTO.author(),
            createBookRequestDTO.isbn(),
            createBookRequestDTO.description(),
            createBookRequestDTO.imageUrl(),
            createBookRequestDTO.pageCount(),
            createBookRequestDTO.publishDate(),
            List.of(),
            createBookRequestDTO.categories()
        );
    }

    public static Book toBook(UpdateBookRequestDTO updateBookRequestDTO) {
        return new Book(
            updateBookRequestDTO.id(),
            updateBookRequestDTO.title(),
            updateBookRequestDTO.author(),
            updateBookRequestDTO.isbn(),
            updateBookRequestDTO.description(),
            updateBookRequestDTO.imageUrl(),
            updateBookRequestDTO.pageCount(),
            updateBookRequestDTO.publishDate(),
            updateBookRequestDTO.reviews(),
            updateBookRequestDTO.categories()
        );
    }
}
