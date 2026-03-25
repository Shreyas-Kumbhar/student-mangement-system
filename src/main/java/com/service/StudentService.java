package com.service;

import com.model.Student;
import com.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }
    //create student
    public Student createStudent(Student student) {
        return repo.save(student);
    }
    //get all students
    public List<Student> displayAllStudents() {
        return repo.findAll();
    }
    //get student by ID
    public Student displayById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }
    //update student by ID
    public Student updateStudent(Long id, Student student) {
        Student ex=repo.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        if(student.getName()!=null){ex.setName(student.getName());}
        if(student.getEmail()!=null){ex.setEmail(student.getEmail());}
        if(student.getPhone()!=null){ex.setPhone(student.getPhone());}
        if(student.getAddress()!=null){ex.setAddress(student.getAddress());}
        if (student.getPassword() != null && !student.getPassword().isEmpty()) {
            ex.setPassword(student.getPassword());
        }
        return repo.save(ex);
    }
    //delete by id
    public void deleteById(Long id) {
        if(!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        repo.deleteById(id);
    }
    //delete all
    public void deleteAllStudents() {
        repo.deleteAll();
    }

}

