package com.stud.stud_man.service;

import com.model.Student;
import com.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("Name");
        student.setAddress("Some Address");
        student.setPassword("123456");
        student.setEmail("email@example.com");
        student.setPhone("1234567890");

        Student savedStudent = studentService.createStudent(student);
        assertNotNull(savedStudent.getId());
        assertEquals("Name", savedStudent.getName());
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setName("Old Name");
        student.setAddress("Some Address");
        student.setPassword("123456");
        student.setEmail("email@example.com");
        student.setPhone("1234567890");

        Student saved = studentService.createStudent(student);

        Student update = new Student();
        update.setName("New Name");
        // other fields optional if updateStudent only changes name

        Student updated = studentService.updateStudent(saved.getId(), update);
        assertEquals("New Name", updated.getName());
    }

    @Test
    public void testDisplayStudent() {
        Student student = new Student();
        student.setName("Name");
        student.setAddress("Some Address");
        student.setPassword("123456");
        student.setEmail("email@example.com");
        student.setPhone("1234567890");

        Student saved = studentService.createStudent(student);
        Student found = studentService.displayById(saved.getId());
        assertEquals(saved.getName(), found.getName());
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student();
        student.setName("Name");
        student.setAddress("Some Address");
        student.setPassword("123456");
        student.setEmail("email@example.com");
        student.setPhone("1234567890");

        Student saved = studentService.createStudent(student);
        studentService.deleteById(saved.getId());

        assertThrows(ResponseStatusException.class,
                () -> studentService.displayById(saved.getId()));
    }
}
//Revised