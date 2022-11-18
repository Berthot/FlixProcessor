package flix.processor.user.controller;

import flix.processor.user.dto.UserDto;
import flix.processor.user.dto.ValidateUserRequestDto;
import flix.processor.user.entity.User;
import flix.processor.user.service.UserService;
import flix.processor.user.util.excecao.GenericException;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.var;
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
    public ResponseEntity<?> Create(@RequestBody UserDto userDto) throws GenericException {

        var user = userService.Create(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> ValidateUser(@RequestBody ValidateUserRequestDto validate) {

        var validated = userService.ValidateUser(validate);
        return new ResponseEntity<>(validated, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<User> GetAll() {

        return userService.GetAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> GetById(@PathVariable("id") Integer id) {
        try {
            User user = userService.GetById(id);
            var dto = new UserDto(user);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") Integer id) {
        userService.Delete(id);
    }

}
