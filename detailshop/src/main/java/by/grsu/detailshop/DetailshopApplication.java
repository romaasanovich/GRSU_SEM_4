package by.grsu.detailshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DetailshopApplication {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("root"));
		System.out.println(new BCryptPasswordEncoder().encode("cust"));
		SpringApplication.run(DetailshopApplication.class, args);
	}
}
