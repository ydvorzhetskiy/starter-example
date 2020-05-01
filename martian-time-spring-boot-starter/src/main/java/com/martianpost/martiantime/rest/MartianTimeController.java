package com.martianpost.martiantime.rest;

import com.martianpost.martiantime.service.MartianTimeService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@ConditionalOnWebApplication
@RestController
public class MartianTimeController {

    private final MartianTimeService martianTimeService;

    public MartianTimeController(MartianTimeService martianTimeService) {
        this.martianTimeService = martianTimeService;
    }

    @GetMapping("/msd/current")
    public double getMds() {
        return martianTimeService.toMarsSolDate(ZonedDateTime.now());
    }
}
