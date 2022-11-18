package flix.processor.ImageProcessor.repository.DataSeed;

import flix.processor.ImageProcessor.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    DataRepository dataRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
