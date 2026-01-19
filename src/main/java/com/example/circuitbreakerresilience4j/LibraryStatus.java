package com.example.circuitbreakerresilience4j;

import java.time.LocalDateTime;

public class LibraryStatus {
    private String status;
    private String message;
    private String timestamp;

    public LibraryStatus(String status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
