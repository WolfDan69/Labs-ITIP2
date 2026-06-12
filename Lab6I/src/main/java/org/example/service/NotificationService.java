package org.example.service;
import org.example.model.dto.NotificationDto; import org.example.model.entity.*; import org.example.model.enums.*; import org.example.repository.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.time.LocalDateTime; import java.util.List;
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository; private final UserRepository userRepository;
    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository){this.notificationRepository=notificationRepository; this.userRepository=userRepository;}
    @Transactional public Notification createNotification(NotificationDto dto){ User user=userRepository.findById(dto.getRecipientId()).orElseThrow(()->new IllegalArgumentException("Получатель не найден")); Notification n=new Notification(); n.setTitle(dto.getTitle()); n.setMessage(dto.getMessage()); n.setChannel(dto.getChannel()); n.setStatus(NotificationStatus.CREATED); n.setRecipient(user); return notificationRepository.save(n); }
    public List<Notification> getAllNotifications(){return notificationRepository.findAll();}
    public Notification getNotificationById(Long id){return notificationRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Уведомление не найдено"));}
    public List<Notification> getNotificationsByStatus(NotificationStatus status){return notificationRepository.findByStatus(status);} public List<Notification> getNotificationsByChannel(NotificationChannel channel){return notificationRepository.findByChannel(channel);} public List<Notification> getNotificationsByRecipientId(Long id){return notificationRepository.findByRecipientId(id);}
    @Transactional public Notification markAsSent(Long id){ Notification n=getNotificationById(id); n.setStatus(NotificationStatus.SENT); n.setSentAt(LocalDateTime.now()); return notificationRepository.save(n); }
    @Transactional public void deleteNotification(Long id){notificationRepository.delete(getNotificationById(id));}
}
