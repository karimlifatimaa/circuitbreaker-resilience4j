package com.example.circuitbreakerresilience4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final ExternalService externalService;

    public StudentService(ExternalService externalService) {
        this.externalService = externalService;
    }

    @CircuitBreaker(name = "studentService", fallbackMethod = "fallbackMethod")
    public String checkStudentStatus() {

        return externalService.checkLibraryExistance();
    }

    public String fallbackMethod(Exception e) {

        return "Fallback: Library is unavailable. Assuming student is clear.";
    }
}
