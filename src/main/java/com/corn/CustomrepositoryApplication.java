package com.corn;

import com.corn.customRepository.BasicCustomizingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BasicCustomizingRepository.class)
public class CustomrepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomrepositoryApplication.class, args);
    }

}
