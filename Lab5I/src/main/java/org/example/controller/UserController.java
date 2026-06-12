package org.example.controller;
import jakarta.validation.Valid; import org.example.model.dto.UserDto; import org.example.model.entity.User; import org.example.service.UserService; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/users")
public class UserController { private final UserService userService; public UserController(UserService userService){this.userService=userService;}
    @PostMapping("/add") public User create(@RequestBody @Valid UserDto dto){return userService.createUser(dto);} @GetMapping("/all") public List<User> all(){return userService.getAllUsers();}
    @GetMapping("/{id}") public User byId(@PathVariable Long id){return userService.getUserById(id);} @PutMapping("/{id}") public User update(@PathVariable Long id,@RequestBody @Valid UserDto dto){return userService.updateUser(id,dto);} @DeleteMapping("/{id}") public void delete(@PathVariable Long id){userService.deleteUser(id);} }
