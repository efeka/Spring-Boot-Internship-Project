package com.efekaraman.staj.stajprojesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InternshipProject {//} implements CommandLineRunner {

	/*
	@Autowired
	private CustomerRepository repository;
	*/

	public static void main(String[] args) {
		SpringApplication.run(InternshipProject.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		repository.save(new Customer(1, "Efe", new Date(), "example@example.com"));
		repository.save(new Customer(2, "Efe123", new Date(), "example123@example.com"));

		System.out.println("findall");
		for (Customer customer : repository.findAll())
			System.out.println(customer);

		System.out.println("id=2 olan");
		System.out.println(repository.findById(2));
	}
	 */
}
