package biblioexp.bibleo.Entity;

import biblioexp.bibleo.Controller.CategoryRepository;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ISBN;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "nbr_copies")
    private long nbr_copies;
    @Column(name = "avb_copies")
    private long avb_copies;
    @Column(name = "date_publication")
    private Date date_pub;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Book(String title, String author, long nbr_exp, Date date_pub, Category category) {
        this.title = title;
        this.author = author;
        this.nbr_copies = nbr_exp;
        this.date_pub = date_pub;
        this.category = category;
    }

    public Book() {

    }


    public Date getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(Date date_pub) {
        this.date_pub = date_pub;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getNbr_exp() {
        return nbr_copies;
    }

    public void setNbr_exp(long nbr_exp) {
        this.nbr_copies = nbr_exp;
    }



    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
