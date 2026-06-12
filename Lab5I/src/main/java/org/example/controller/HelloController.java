package org.example.controller; import org.springframework.web.bind.annotation.*;
@RestController public class HelloController { @GetMapping("/hello") public String hello(){return "Hello";} }
