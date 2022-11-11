package flix.processor.user.repository.DataSeed;

import flix.processor.user.entity.User;
import flix.processor.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UserDataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {
            User user1 = new User("john", "wick", "dog");
            User user2 = new User("bob", "marley", "green");
            userRepository.save(user1);
            userRepository.save(user2);
        }
//        System.out.println(userRepository.count());
    }
}
