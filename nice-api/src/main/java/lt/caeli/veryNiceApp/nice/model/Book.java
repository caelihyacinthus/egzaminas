package lt.caeli.veryNiceApp.nice.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private String isbn;
    private String description;
    private String imageUrl;
    private int pageCount;
    private LocalDate publishDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
        name = "book_categories",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    public Book(String title, String author, String isbn, String description, String imageUrl, int pageCount, LocalDate publishDate, List<Review> reviews, List<Category> categories) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.imageUrl = imageUrl;
        this.pageCount = pageCount;
        this.publishDate = publishDate;
        this.reviews = reviews;
        this.categories = categories;
    }

    public Book(long id, String title, String author, String isbn, String description, String imageUrl, int pageCount, LocalDate publishDate, List<Review> reviews, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.imageUrl = imageUrl;
        this.pageCount = pageCount;
        this.publishDate = publishDate;
        this.reviews = reviews;
        this.categories = categories;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
