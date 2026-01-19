package com.example.circuitbreakerresilience4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final StudentService studentService;

    public DemoController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/check")
    public String check() {
        return studentService.checkStudentStatus();
    }
}
