package org.example.model.entity;
import jakarta.persistence.*; import org.example.model.enums.NotificationChannel; import org.example.model.enums.NotificationStatus; import java.time.LocalDateTime;
@Entity @Table(name="notifications")
public class Notification {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String title;
    @Column(nullable=false, length=2000) private String message;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private NotificationChannel channel;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private NotificationStatus status = NotificationStatus.CREATED;
    private LocalDateTime createdAt = LocalDateTime.now(); private LocalDateTime sentAt;
    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="recipient_id") private User recipient;
    public Long getId(){return id;} public void setId(Long id){this.id=id;} public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
    public String getMessage(){return message;} public void setMessage(String message){this.message=message;} public NotificationChannel getChannel(){return channel;} public void setChannel(NotificationChannel channel){this.channel=channel;}
    public NotificationStatus getStatus(){return status;} public void setStatus(NotificationStatus status){this.status=status;} public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public LocalDateTime getSentAt(){return sentAt;} public void setSentAt(LocalDateTime sentAt){this.sentAt=sentAt;} public User getRecipient(){return recipient;} public void setRecipient(User recipient){this.recipient=recipient;}
}
