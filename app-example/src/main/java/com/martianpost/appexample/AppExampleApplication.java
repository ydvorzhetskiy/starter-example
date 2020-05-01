package com.martianpost.appexample;

import com.martianpost.martiantime.service.MartianTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;

@SpringBootApplication
public class AppExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppExampleApplication.class, args);
    }

    @Autowired
    private MartianTimeService martianTimeService;

    @PostConstruct
    public void printCurrentTime() {
        double currentMarsSolDate = martianTimeService.toMarsSolDate(ZonedDateTime.now());
        System.out.println("MSD: " + currentMarsSolDate);
    }
}
