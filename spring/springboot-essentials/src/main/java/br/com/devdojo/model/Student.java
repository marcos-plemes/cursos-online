package br.com.devdojo.model;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Student {
    
    private int id;
    
    private String name;
    
    public static List<Student> studentList;
    static {
        studentRepository();
    }
    
    public Student(final String name) {
        this.name = name;
    }
    
    public Student(final int id, final String name) {
        this(name);
        this.id = id;
    }
    
    public Student() {}
    
    private static void studentRepository() {
        studentList = new ArrayList<>(asList(new Student(1, "Deku"), new Student(2, "Todoroki")));
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.id;
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public static List<Student> getStudentList() {
        return studentList;
    }
    
    public static void setStudentList(final List<Student> studentList) {
        Student.studentList = studentList;
    }
    
}
