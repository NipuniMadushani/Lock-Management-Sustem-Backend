package lk.esoft.batch18.lockhoodmanagementsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityJwtApplication implements CommandLineRunner {

	public static void main(String[] args) {
    SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("mmmmmmmm");

	}
}


