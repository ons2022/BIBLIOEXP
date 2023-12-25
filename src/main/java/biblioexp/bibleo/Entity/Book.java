package biblioexp.bibleo.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
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

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Loan> loans = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Notification> notifications = new HashSet<>();

    // Constructors, getters, and setters...

    public void addLoan(Loan loan) {
        loans.add(loan);
        loan.setBook(this);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.setBook(null);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setBook(this);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setBook(null);
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
        notification.setBook(this);
    }

    public void removeNotification(Notification notification) {
        notifications.remove(notification);
        notification.setBook(null);
    }

    // ... other methods as needed
}
