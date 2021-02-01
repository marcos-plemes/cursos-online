package br.com.devdojo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devdojo.error.CustomErrorType;
import br.com.devdojo.model.Student;
import br.com.devdojo.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentEndpoint {
    
    private final StudentRepository studentDAO;
    
    @Autowired
    public StudentEndpoint(final StudentRepository studentDAO) {
        this.studentDAO = studentDAO;
    }
    
    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(this.studentDAO.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") final Long id) {
        final Student student = this.studentDAO.findById(id).orElseThrow(() -> new IllegalStateException("Esse parça não consta"));
        if (student == null) {
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody final Student student) {
        return new ResponseEntity<>(this.studentDAO.save(student), HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id) {
        this.studentDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody final Student student) {
        this.studentDAO.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
