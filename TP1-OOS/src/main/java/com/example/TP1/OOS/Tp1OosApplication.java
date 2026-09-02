package com.example.TP1.OOS;

import com.example.TP1.OOS.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp1OosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp1OosApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CarService carService) {
		return (args) -> {
			carService.addCar(new Car("11AA22", "Ferrari", 100));
			carService.addCar(new Car("33BB44", "Renault", 40));
			carService.addCar(new Car("55CC66", "BMW", 80));
			carService.addCar(new Car("AA11BB", "Toyota", 60));
		};
	}
}