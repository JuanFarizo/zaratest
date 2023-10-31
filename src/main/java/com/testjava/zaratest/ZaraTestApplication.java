package com.testjava.zaratest;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.TimeZone.getTimeZone;
import static java.util.TimeZone.setDefault;

@SpringBootApplication
public class ZaraTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZaraTestApplication.class, args);
    }

    @PostConstruct
    public void init() {
        setDefault(getTimeZone("UTC"));
    }
}
