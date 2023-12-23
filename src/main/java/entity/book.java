package entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="books")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ISBN;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "nombre exemplaires")
    private long nbr_exp;
    @Column(name = "date_publication")
    private Date date_pub;

    public book(String title, String author, long nbr_exp, Date date_pub) {
        this.title = title;
        this.author = author;
        this.nbr_exp = nbr_exp;
        this.date_pub = date_pub;
    }

    public book() {

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
        return nbr_exp;
    }

    public void setNbr_exp(long nbr_exp) {
        this.nbr_exp = nbr_exp;
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

}
