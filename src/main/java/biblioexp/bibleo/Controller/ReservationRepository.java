package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByUserId(Long userId);
}
