package lt.caeli.veryNiceApp.nice.service;

import lt.caeli.veryNiceApp.nice.model.Book;
import lt.caeli.veryNiceApp.nice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public boolean existsBookById(long id) {
        return bookRepository.existsById(id);
    }

    public Optional<Book> findBookById(long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAllBooksByTitleContaining(String title) {
        return bookRepository.findAllByTitleContaining(title);
    }

    public List<Book> findAllBooksByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    public Page<Book> findAllBooksPage(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }
}
