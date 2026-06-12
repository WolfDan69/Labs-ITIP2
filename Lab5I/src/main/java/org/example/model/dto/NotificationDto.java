package org.example.model.dto;
import jakarta.validation.constraints.*; import org.example.model.enums.NotificationChannel;
public class NotificationDto {
    @NotBlank private String title; @NotBlank private String message; @NotNull private NotificationChannel channel; @NotNull private Long recipientId;
    public String getTitle(){return title;} public void setTitle(String title){this.title=title;} public String getMessage(){return message;} public void setMessage(String message){this.message=message;}
    public NotificationChannel getChannel(){return channel;} public void setChannel(NotificationChannel channel){this.channel=channel;} public Long getRecipientId(){return recipientId;} public void setRecipientId(Long recipientId){this.recipientId=recipientId;}
}
