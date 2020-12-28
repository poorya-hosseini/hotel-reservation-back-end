package com.hotel.reservation;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.hotel.reservation.domain.User;
import com.hotel.reservation.persistence.UserRepo;
import com.hotel.reservation.service.HotelService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepo repository, HotelService hotelService) {
		return (args) -> {
			// save a few customers
			repository.save(
				new User.Builder()
					.withFirstname("Poorya")
					.withLastname("Hosseini")
					.withUsername("testuser")
					.withPassword("testpassword")
					.build()
			);

			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (User user : repository.findAll()) {
				System.out.println(user);
			}

			// fetch an individual customer by ID
			System.out.println("Customer found with findById(1L):");
			System.out.println("--------------------------------");
			System.out.println(repository.findById(1L));

			// fetch an available rooms
			System.out.println("Customer found with findById(1L):");
			System.out.println("--------------------------------");
			System.out.println(hotelService.getAvailableRooms(new Date(), new Date()));

//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			//  log.info(bauer.toString());
//			// }
//			log.info("");
		};
	}

}