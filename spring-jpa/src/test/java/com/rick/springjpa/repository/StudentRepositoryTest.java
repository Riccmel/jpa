package com.rick.springjpa.repository;

import com.rick.springjpa.entity.Guardian;
import com.rick.springjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("Pino@gmail.com")
                .firstName("Franco")
                .lastName("Pelli")
                //.guardianName("Nikk")
                //.guardianEmail("Nikk@gmail.com")
                //.guardianMobile("123456789")
                .build();

        studentRepository.save(student);
    }


    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("Nikk@gmail.com")
                .name("Nikk")
                .mobile("123456789")
                .build();

        Student student = Student.builder()
                .emailId("Pina@gmail.com")
                .firstName("Franco")
                .lastName("Pelli")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Franco");

        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("co");

        System.out.println(students);
    }
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("");

        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("Pino@gmail.com");

        System.out.println(student);
    }


}