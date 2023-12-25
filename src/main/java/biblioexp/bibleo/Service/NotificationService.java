package biblioexp.bibleo.Service;
import biblioexp.bibleo.Repository.NotificationRepository;
import biblioexp.bibleo.Entity.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(long id) {
        Optional<Notification> optionalNotification = notificationRepository.findById(id);
        return optionalNotification.orElse(null);
    }

    public Notification createNotification(Notification notification) {
        // You can add additional business logic/validation before saving
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(long id, Notification updatedNotification) {
        Optional<Notification> optionalNotification = notificationRepository.findById(id);

        if (optionalNotification.isPresent()) {
            Notification existingNotification = optionalNotification.get();
            // Update the existing notification with the new values
            /*existingNotification.setUser(updatedNotification.getUser());
            existingNotification.setBook(updatedNotification.getBook());
            existingNotification.setNotificationType(updatedNotification.getNotificationType());
            existingNotification.setMessage(updatedNotification.getMessage());
            existingNotification.setNotificationDate(updatedNotification.getNotificationDate());*/

            // Save the updated notification
            return notificationRepository.save(existingNotification);
        } else {
            return null; // Handle not found scenario
        }
    }

    public void deleteNotification(long id) {
        notificationRepository.deleteById(id);
    }
}
