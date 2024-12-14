package tn.esprit.springexamen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringExamenApplication {

    public static void main(String[] args) {
        SpringApplication.run ( SpringExamenApplication.class, args );
    }

}
