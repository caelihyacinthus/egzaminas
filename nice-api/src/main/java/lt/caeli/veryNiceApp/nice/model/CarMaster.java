package lt.caeli.veryNiceApp.nice.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "car_meistras")
public class CarMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
        name = "cars_services",
        joinColumns = @JoinColumn(name = "meistras_id"),
        inverseJoinColumns = @JoinColumn(name = "cat_id")
    )
    private List<Category> categories;

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

    public CarMaster(String name, List<Review> reviews, List<Category> categories) {
        this.name = name;
        this.reviews = reviews;
        this.categories = categories;
    }

    public CarMaster(long id, String name, List<Review> reviews, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.reviews = reviews;
        this.categories = categories;
    }

    public CarMaster() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
