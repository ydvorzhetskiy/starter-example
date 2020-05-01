package com.martianpost.martiantime.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.ZonedDateTime;

@Service
public class MartianTimeService {

    private static final ZonedDateTime MID_DAY = ZonedDateTime.parse("2000-01-06T00:00:00Z");

    public double toMarsSolDate(ZonedDateTime zonedDateTime) {
        double secondsFromMidDay = (double) Duration.between(MID_DAY, zonedDateTime).getSeconds();
        return secondsFromMidDay / 88775.244 + 44795.9998;
    }
}
