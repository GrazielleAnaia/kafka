package com.demo.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class FunctionsClass {

    @Bean
    public Function<String, String> upperCase() {
        return value -> value.toUpperCase();
    }

    @Bean
    public Consumer<String> delete() {
        return System.out::println;
    }

    @Bean
    public Function<String, String> reverseString() {
        return value -> new StringBuilder(value).reverse().toString();
    }

    @Bean
    public Supplier<RiderLocation> sendRiderLocation() {

        Random random = new Random();
        return () -> {
            String riderId = "riderID " + random.nextInt(20);
            RiderLocation location = new RiderLocation(riderId, 46.7, 56.8);
            System.out.println("Sending riderID: " + location.getRiderId());
            return location;
        };
    }
}
