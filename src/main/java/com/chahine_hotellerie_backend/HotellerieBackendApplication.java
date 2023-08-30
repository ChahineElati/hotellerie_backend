package com.chahine_hotellerie_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotellerieBackendApplication  implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(HotellerieBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	}

}