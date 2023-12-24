package biblioexp.bibleo.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "notification_type")
    private NotificationType notificationType;

    @Column(name = "message")
    private String message;

    @Column(name = "notification_date")
    private Date notificationDate;

    // constructors, getters, and setters...
}

