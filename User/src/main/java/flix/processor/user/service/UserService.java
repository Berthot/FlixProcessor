package flix.processor.user.service;

import flix.processor.user.dto.UserDto;
import flix.processor.user.dto.ValidateUserRequestDto;
import flix.processor.user.dto.ValidateUserResponseDto;
import flix.processor.user.entity.User;
import flix.processor.user.repository.UserRepository;
import flix.processor.user.util.excecao.GenericException;
import lombok.var;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto Create(UserDto userDto) throws GenericException {
        var encrypted = passwordEncoder().encode(userDto.getPassword());
        var user = new User(userDto.getName(), userDto.getLogin(), encrypted);
        if (GetUserIsNotValid(user)) {
            throw new GenericException("ERR001", "entity data are invalid");
        }

        var userSaved=  userRepository.save(user);
        return new UserDto(userSaved);
    }
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private static boolean GetUserIsNotValid(User user) {
        return user.getName() == null || user.getName().equals("") || user.getName().length() > 300;
    }

    public List<User> GetAll() {
        return userRepository.findAll();
    }

    public User GetById(Integer id) {
        User user;
        try {
            user = userRepository.findById(id).get();
        } catch (Exception ex) {
            user = new User();
        }
        return user;


    }

    public void Delete(Integer id) {
        userRepository.deleteById(id);
    }


    public ValidateUserResponseDto ValidateUser(ValidateUserRequestDto validate) {
        try {
            var user = GetById(validate.getUserId());
            return new ValidateUserResponseDto(!user.getName().equals(""));
        }
        catch (Exception ex){
            return new ValidateUserResponseDto(false);
        }
    }
}
