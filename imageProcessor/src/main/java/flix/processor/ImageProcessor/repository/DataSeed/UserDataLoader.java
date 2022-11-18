package flix.processor.ImageProcessor.repository.DataSeed;

import flix.processor.ImageProcessor.entity.Data;
import flix.processor.ImageProcessor.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


public class UserDataLoader implements CommandLineRunner {
    @Autowired
    DataRepository dataRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (dataRepository.count() == 0) {
            Data data = new Data();
            data.setValue("ASD");
            data.setUserId(1);
            data.setTier("A");
            dataRepository.save(data);
        }
//        System.out.println(userRepository.count());
    }
}
