package pe.edu.upc.MeetUsSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"main.controllers", "main.repositories"})
@EnableJpaRepositories("main.repositories")
@SpringBootApplication
public class MeetUsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetUsSpringApplication.class, args);
	}

}
