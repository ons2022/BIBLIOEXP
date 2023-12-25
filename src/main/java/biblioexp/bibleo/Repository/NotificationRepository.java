package biblioexp.bibleo.Repository;


import biblioexp.bibleo.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // You can add custom query methods if needed
}

