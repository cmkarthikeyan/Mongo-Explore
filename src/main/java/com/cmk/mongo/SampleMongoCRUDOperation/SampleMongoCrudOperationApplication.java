package com.cmk.mongo.SampleMongoCRUDOperation;

import com.cmk.mongo.SampleMongoCRUDOperation.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SampleMongoCrudOperationApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SampleMongoCrudOperationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    /*List<Users> usersList = new ArrayList<>();
		StopWatch stopWatch = new StopWatch("Measuring bulk insert time");
		stopWatch.start();
		LongStream.rangeClosed(1,20).forEach(no -> {
			Users users = Users.builder()
					.userId(BigDecimal.valueOf(no+Math.random()))
					.firstName("CMKay_F_Name_"+no)
					.lastName("CMKay_L_Name_"+no)
					.departmentId(no)
					.email("cmkay@gmail.com")
					.build();
			usersList.add(users);
		});*/

		/*System.out.println("Starting insert :::");

		List<Users> usersList = new ArrayList<>();
		LongStream.rangeClosed(2000001, 4000000).forEach(no -> {
			final var address = Address.builder()
					.city("city_" + no)
					.state("state_" + no)
					.pinCode(Math.toIntExact(no))
					.build();

			final var users = Users.builder()
					.userId(no)
					.firstName(no + "_F_Name")
					.lastName("L_Name_" + no)
					.email("test_" + no + "@gmail.com")
					.address(address)
					.build();
			usersList.add(users);
		});
		userRepository.saveAll(usersList);
		System.out.println("Ending insert :::");*/
	}
}
