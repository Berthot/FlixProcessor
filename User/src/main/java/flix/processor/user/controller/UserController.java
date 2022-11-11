package flix.processor.user.controller;

import flix.processor.user.entity.User;
import flix.processor.user.service.UserService;
import flix.processor.user.util.excecao.InvalidEntity;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/user")
@SecurityScheme(
        name = "Bearer",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> Create(@RequestBody User user) throws InvalidEntity {
        user = userService.Create(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> GetAll() {

        return userService.GetAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> GetById(@PathVariable("id") Integer id) {
        try {
            User user = userService.GetById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") Integer id) {
        userService.Delete(id);
    }

}
