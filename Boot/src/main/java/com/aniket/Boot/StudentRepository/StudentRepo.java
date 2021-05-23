package com.aniket.Boot.StudentRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniket.Boot.StudentModel.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> 
{
	Optional<Student> findStudentByEmail(String email);
}
