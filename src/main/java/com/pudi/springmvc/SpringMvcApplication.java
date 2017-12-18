package com.pudi.springmvc;

import com.pudi.springmvc.dto.CreateTaskDto;
import com.pudi.springmvc.model.User;
import com.pudi.springmvc.service.TaskService;
import com.pudi.springmvc.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	public CommandLineRunner testData(final UserService userService, final TaskService taskService) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {

				User user = new User();
				user.setFirstName("John");
				user.setLastName("Doe");
				user.setEmail("noneofyour@business.org");
				user.setPassword("123");
				userService.createUser(user);

				CreateTaskDto createTask1 = new CreateTaskDto();
				createTask1.setTitle("Very important");
				createTask1.setAuthorId(user.getId());
				taskService.createTask(createTask1);

				CreateTaskDto createTask2 = new CreateTaskDto();
				createTask2.setTitle("Also very important");
				createTask2.setAuthorId(user.getId());
				taskService.createTask(createTask2);

			}
		};
	}
}
