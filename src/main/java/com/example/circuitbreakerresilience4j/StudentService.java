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
    public LibraryStatus checkStudentStatus() {
        return externalService.checkLibraryExistance();
    }

    public LibraryStatus fallbackMethod(Exception e) {
        return new LibraryStatus("FALLBACK",
                "Library is unavailable. Assuming student is clear. Error: " + e.getMessage());
    }
}
