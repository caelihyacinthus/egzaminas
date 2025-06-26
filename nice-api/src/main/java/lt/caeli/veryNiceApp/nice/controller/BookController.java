package lt.caeli.veryNiceApp.nice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lt.caeli.veryNiceApp.nice.dto.book.*;
import lt.caeli.veryNiceApp.nice.model.Book;
import lt.caeli.veryNiceApp.nice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<GetPartialBookResponseDTO>> getBooks(@RequestParam(defaultValue = "10") @Min(value = 1) int size, @RequestParam(defaultValue = "1") @Min(value = 1) int page) {
        return ResponseEntity.ok(bookService.findAllBooksPage(size, page)
            .stream()
            .map(BookMapper::toGetPartialBookResponseDTO)
            .toList()
        );
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<GetBookResponseDTO> getBook(@PathVariable long id) {
        Optional<Book> maybeBook = bookService.findBookById(id);

        if (maybeBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(BookMapper.toGetBookResponseDTO(maybeBook.get()));
    }

    @PostMapping("/books")
    public ResponseEntity<CreateBookResponseDTO> addBook(@Valid @RequestBody CreateBookRequestDTO createBookRequestDTO) {
        Book savedBook = bookService.saveBook(BookMapper.toBook(createBookRequestDTO));

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedBook.getId())
                    .toUri())
            .body(BookMapper.toCreateBookResponseDTO(savedBook));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody UpdateBookRequestDTO updateBookRequestDTO) {
        if (bookService.existsBookById(id)) {
            Book bookFromDb = bookService.findBookById(id).get();
            Book savedBook = bookService.saveBook(bookFromDb);

            return ResponseEntity.ok(BookMapper.toUpdateBookResponseDTO(savedBook));
        }

        Book savedBook = bookService.saveBook(BookMapper.toBook(updateBookRequestDTO));

        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                    .replacePath("/api/books/{id}")
                    .buildAndExpand(savedBook.getId())
                    .toUri())
            .body(BookMapper.toUpdateBookResponseDTO(savedBook));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        if (!bookService.existsBookById(id)) {
            return ResponseEntity.notFound().build();
        }

        bookService.deleteBookById(id);

        return ResponseEntity.noContent().build();
    }
}