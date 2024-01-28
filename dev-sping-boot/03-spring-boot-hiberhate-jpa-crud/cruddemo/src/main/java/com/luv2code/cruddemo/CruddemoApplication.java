package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){

		return runner -> {
			//createStudent(studentDao);
			createMultipleStudents(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudents(studentDao);
			
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {

		System.out.println("Deleting all students..");

		int numRowsDeleted = studentDao.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);

	}

	private void deleteStudent(StudentDao studentDao) {

		int studentId = 3;

		System.out.println("Deleting student id: " + studentId);

		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDao.findById(studentId);

		System.out.println("Updating student...");

		myStudent.setFirstName("John");
		studentDao.update((myStudent));

		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {

		List<Student> theStudents = studentDao.findByLastName("Foe");

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {

		List<Student> theStudents = studentDao.findAll();

		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}


	private void readStudent(StudentDao studentDao) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daisy", "Dog", "daisy@gmail.com");

		System.out.println("Saving the student...");
		studentDao.save(tempStudent);

		System.out.println("Saved student. Generated id: "+tempStudent.getId());

		System.out.println("Retrieving student with id: "+ tempStudent.getId());

		Student myStudent = studentDao.findById(tempStudent.getId());

		System.out.println("Found the student: "+ myStudent);
	}

	private void createMultipleStudents(StudentDao studentDao) {

		System.out.println("Create new student object..");

		Student tempStudent1 = new Student("John", "foe", "john@gamil.com");
		Student tempStudent2 = new Student("Mary", "jane", "mary@gamil.com");
		Student tempStudent3 = new Student("Tedd", "bone", "tedd@gamil.com");

		System.out.println("Saving the students...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);
	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("Create new student object..");
		Student tempStudent = new Student("Paul", "Doe", "paul@gamil.com");


		System.out.println("Saving the student..");
		studentDao.save(tempStudent);

		System.out.println("Saved student. Generated id: "+tempStudent.getId());

	}

}
