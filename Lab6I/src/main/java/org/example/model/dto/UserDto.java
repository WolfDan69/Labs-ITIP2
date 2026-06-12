package org.example.model.dto;
import jakarta.validation.constraints.*; import org.example.model.enums.UserRole;
public class UserDto {
    @NotBlank private String name; @Email @NotBlank private String email; private String phone; private String deviceToken; private String telegramChatId; private UserRole role = UserRole.ROLE_USER;
    public String getName(){return name;} public void setName(String name){this.name=name;} public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public String getPhone(){return phone;} public void setPhone(String phone){this.phone=phone;} public String getDeviceToken(){return deviceToken;} public void setDeviceToken(String deviceToken){this.deviceToken=deviceToken;}
    public String getTelegramChatId(){return telegramChatId;} public void setTelegramChatId(String telegramChatId){this.telegramChatId=telegramChatId;} public UserRole getRole(){return role;} public void setRole(UserRole role){this.role=role;}
}
