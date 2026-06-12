package org.example.model.entity;
import jakarta.persistence.*; import org.example.model.enums.UserRole; import java.time.LocalDateTime; import java.util.ArrayList; import java.util.List;
@Entity @Table(name="users")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String email;
    @Column(nullable=false) private String password = "default123";
    @Enumerated(EnumType.STRING) @Column(nullable=false) private UserRole role = UserRole.ROLE_USER;
    private String phone; private String deviceToken; private String telegramChatId; private LocalDateTime createdAt = LocalDateTime.now();
    @OneToMany(mappedBy="recipient", cascade=CascadeType.ALL, orphanRemoval=true) private List<Notification> notifications = new ArrayList<>();
    public Long getId(){return id;} public void setId(Long id){this.id=id;} public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;} public String getPassword(){return password;} public void setPassword(String password){this.password=password;}
    public UserRole getRole(){return role;} public void setRole(UserRole role){this.role=role;} public String getPhone(){return phone;} public void setPhone(String phone){this.phone=phone;}
    public String getDeviceToken(){return deviceToken;} public void setDeviceToken(String deviceToken){this.deviceToken=deviceToken;} public String getTelegramChatId(){return telegramChatId;} public void setTelegramChatId(String telegramChatId){this.telegramChatId=telegramChatId;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;} public List<Notification> getNotifications(){return notifications;} public void setNotifications(List<Notification> notifications){this.notifications=notifications;}
}
