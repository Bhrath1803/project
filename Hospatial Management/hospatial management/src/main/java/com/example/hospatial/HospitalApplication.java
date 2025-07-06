package com.example.hospatial;

import Model.Doctor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import repository.DoctorRepository;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(DoctorRepository doctorRepo){
    return args ->{
         if(doctorRepo.count()==0 ){
            doctorRepo.save(new Doctor("DR.ajith" , "cardiology"));
			 doctorRepo.save(new Doctor("DR.vijay" , "Neuro"));
			 doctorRepo.save(new Doctor("DR.Goweri" , "Skincare"));
         }
	};
	}
}
