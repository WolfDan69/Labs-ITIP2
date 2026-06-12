package org.example.repository;
import org.example.model.entity.Notification; import org.example.model.enums.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface NotificationRepository extends JpaRepository<Notification, Long> { List<Notification> findByStatus(NotificationStatus status); List<Notification> findByChannel(NotificationChannel channel); List<Notification> findByRecipientId(Long recipientId); }
