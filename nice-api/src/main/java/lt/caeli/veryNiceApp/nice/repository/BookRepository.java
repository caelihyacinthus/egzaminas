package lt.caeli.veryNiceApp.nice.repository;

import lt.caeli.veryNiceApp.nice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleContaining(String title);

    List<Book> findAllByTitle(String title);

    @Query("select b from Book b where b.author = ?1")
    List<Book> findAllByAuthor(String author);
}