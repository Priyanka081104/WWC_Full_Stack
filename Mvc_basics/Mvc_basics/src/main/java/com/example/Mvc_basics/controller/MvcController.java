package com.example.Mvc_basics.controller;

import com.example.Mvc_basics.model.Student;
import com.example.Mvc_basics.service.mvcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/student")
public class MvcController {
    private final mvcService ms;

    public MvcController(mvcService ms){
        this.ms = ms;
    }

    @GetMapping
    public ResponseEntity<List<Student>>getAllStudent(){
        return ResponseEntity.ok(ms.getAllStudent());
    }
}
