package flix.processor.user.service;

import flix.processor.user.entity.User;
import flix.processor.user.repository.UserRepository;
import flix.processor.user.util.excecao.InvalidEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User Create(User user) throws InvalidEntity {
        if (GetUserIsNotValid(user)) {
            throw new InvalidEntity("ERR001", "entity data are invalid");
        }

        return userRepository.save(user);
    }

    private static boolean GetUserIsNotValid(User user) {
        return user.getName() == null || user.getName().equals("") || user.getName().length() > 300;
    }

    public List<User> GetAll() {
        return userRepository.findAll();
    }

    public User GetById(Integer id) {
        return userRepository.findById(id).get();

    }

    public void Delete(Integer id) {
        userRepository.deleteById(id);
    }

}
