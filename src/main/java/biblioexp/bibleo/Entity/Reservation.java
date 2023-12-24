package biblioexp.bibleo.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "reservation_date")
    private Date reservationDate;

    // Constructors, getters, and setters...

    public void setUser(User user) {
        this.user = user;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}

