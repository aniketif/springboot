package com.aniket.Boot.StudentService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.Boot.StudentModel.Student;
import com.aniket.Boot.StudentRepository.StudentRepo;

@Service
public class StudentService {
	
	private final StudentRepo studentRepo;
	
	@Autowired
	public StudentService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	
	public List<Student> getStudent()
	{
		return studentRepo.findAll();
	}
	
	public void addStudent(Student student)
	{
		Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()) 
		{
			throw new IllegalStateException("Email Already Taken");
		}
		System.out.println(student);
		studentRepo.save(student);
	}
	
	public void removeStudent(long studentId) 
	{
		boolean exist = studentRepo.existsById(studentId);
		if (!exist) 
		{
			throw new IllegalStateException("Invalid Student ID");
		}
		studentRepo.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) 
	{
		Student student = studentRepo.findById(studentId).orElseThrow(()-> 
		new IllegalStateException("student with id "+studentId+ "does not exist"));
		if (name !=null && name.length()>0 && !Objects.equals(student.getName(), name)) 
		{
			student.setName(name);
		}
		
		if (email !=null && email.length()>0 && !Objects.equals(student.getEmail(), email)) 
		{
			Optional<Student> studendtOptional = studentRepo.findStudentByEmail(email);
			if (studendtOptional.isPresent()) 
			{
				throw new IllegalStateException("Email Already In Use");
			}
			student.setEmail(email);
		}
		
		
	}

	
}
