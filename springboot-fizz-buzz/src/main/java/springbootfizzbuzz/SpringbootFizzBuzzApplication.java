package springbootfizzbuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springbootfizzbuzz.service.FizzBuzzService;

import java.util.Scanner;

@SpringBootApplication
public class SpringbootFizzBuzzApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFizzBuzzApplication.class, args);
	}

	@Autowired
	FizzBuzzService fizzBuzzService;

	@Override
	public void run(String... args) throws Exception {
		try(Scanner scan = new Scanner(System.in)) {
			String userInput = scan.nextLine();

			if(fizzBuzzService.accept(userInput)){
				if(fizzBuzzService.perform(userInput) != "-1")
					System.out.println(fizzBuzzService.perform(userInput));
				else
					System.out.println("Number is not FizzBuzzable");
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		System.exit(0);
	}
}