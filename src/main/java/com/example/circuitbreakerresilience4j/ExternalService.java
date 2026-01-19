package com.example.circuitbreakerresilience4j;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ExternalService {

    public String checkLibraryExistance() {
        // Simulating random failure
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Library Service is down!");
        }
        return "Student has no books due.";
    }
}
