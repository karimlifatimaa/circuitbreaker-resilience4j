package com.example.circuitbreakerresilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerLogConfig {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerLogConfig.class);

    @Bean
    public CommandLineRunner logListener(CircuitBreakerRegistry registry) {
        return args -> {
            // 1. "studentService" adlı Circuit Breaker-i tapırıq
            CircuitBreaker circuitBreaker = registry.circuitBreaker("studentService");

            // 2. Onun vəziyyət dəyişikliklərinə "qulaq asırıq"
            circuitBreaker.getEventPublisher()
                    .onStateTransition(event -> {
                        logger.info("⚡⚡⚡ DİQQƏT! SİGORTA VƏZİYYƏTİ DƏYİŞDİ: {} -> {} ⚡⚡⚡",
                                event.getStateTransition().getFromState(),
                                event.getStateTransition().getToState());
                    });
        };
    }
}
