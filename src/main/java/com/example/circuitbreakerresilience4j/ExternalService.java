package com.example.circuitbreakerresilience4j;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ExternalService {

    private String mode = "NORMAL"; // NORMAL, SLOW, ERROR

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public LibraryStatus checkLibraryExistance() {
        if ("SLOW".equalsIgnoreCase(mode)) {
            try {
                TimeUnit.SECONDS.sleep(3); // 3 saniyə gecikmə
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if ("ERROR".equalsIgnoreCase(mode)) {
            throw new RuntimeException("Simulated External Service Crash!");
        }

        return new LibraryStatus("SUCCESS", "Student has no books due.");
    }
}
