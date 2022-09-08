package com.rick.springjpa.repository;

import com.rick.springjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    //JPQL
    @Query("select s from Student s  where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailId);


    //Native
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address =  ?1",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNative(String emailId);

    //Native Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address =  :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    //Modifica
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
