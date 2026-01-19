package com.example.circuitbreakerresilience4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final StudentService studentService;
    private final ExternalService externalService;

    public DemoController(StudentService studentService, ExternalService externalService) {
        this.studentService = studentService;
        this.externalService = externalService;
    }

    @GetMapping("/check")
    public LibraryStatus check() {
        return studentService.checkStudentStatus();
    }

    @GetMapping("/mode")
    public String setMode(@RequestParam String mode) {
        externalService.setMode(mode);
        return "Mode set to: " + mode;
    }
}
