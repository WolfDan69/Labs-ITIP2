package org.example.service;
import org.example.model.dto.UserDto; import org.example.model.entity.User; import org.example.model.enums.UserRole; import org.example.repository.UserRepository; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.time.LocalDateTime; import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){this.userRepository=userRepository;}
    @Transactional public User createUser(UserDto dto){ User u=new User(); apply(u,dto); u.setCreatedAt(LocalDateTime.now()); return userRepository.save(u); }
    public List<User> getAllUsers(){return userRepository.findAll();}
    public User getUserById(Long id){return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Пользователь не найден"));}
    @Transactional public User updateUser(Long id, UserDto dto){ User u=getUserById(id); apply(u,dto); return userRepository.save(u);}
    @Transactional public void deleteUser(Long id){ userRepository.delete(getUserById(id)); }
    private void apply(User u, UserDto dto){ u.setName(dto.getName()); u.setEmail(dto.getEmail()); u.setPhone(dto.getPhone()); u.setDeviceToken(dto.getDeviceToken()); u.setTelegramChatId(dto.getTelegramChatId()); u.setRole(dto.getRole()==null? UserRole.ROLE_USER : dto.getRole()); }
}
