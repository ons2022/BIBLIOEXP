package biblioexp.bibleo.Entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Loan> loans = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<>();

    // Constructors, getters, and setters...

    public void addLoan(Loan loan) {
        loans.add(loan);
        loan.setUser(this);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.setUser(null);
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setUser(this);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setUser(null);
    }

}
