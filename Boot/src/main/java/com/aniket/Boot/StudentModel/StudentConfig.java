package com.aniket.Boot.StudentModel;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aniket.Boot.StudentRepository.StudentRepo;

@Configuration
public class StudentConfig 
{
	@Bean
	CommandLineRunner conmanLineRunner(StudentRepo studentRepo)
	{
		return  Args ->{
			Student  aniket = new Student("aniket", "aniketif@gmail.com", LocalDate.of(1997, 10, 18));
			Student barb = new Student("barbara", "barbara@gmail.com", LocalDate.of(1997, 10, 18));
			studentRepo.saveAll(List.of(aniket, barb));
		};
		
		
	}
	
}
