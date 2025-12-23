package com.example.Mvc_basics.service;

import com.example.Mvc_basics.model.Student;

import java.util.ArrayList;
import java.util.List;

public class mvcService {
    private List<Student> st = new ArrayList<>();
    public List<Student> getAllStudent(){
        return st;
    }

    public Student getStudentById(int id){
        return st.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Student addStudent(Student s){
        st.add(s);
        return  s;
    }
    public boolean deleteStudent(int id){
        return st.removeIf(e -> e.getId() == id);
    }
}
