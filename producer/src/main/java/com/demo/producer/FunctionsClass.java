package com.demo.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

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
}
