package com.martianpost.martiantime.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Сервис MartianTimeService")
class MartianTimeServiceTest {

    private final MartianTimeService service = new MartianTimeService();

    @DisplayName("должен конвертировать совпадение полночей в 06.01.2000")
    @Test
    void shouldConvertZeroDay() {
        ZonedDateTime zeroDayUtc = ZonedDateTime.parse("2000-01-06T00:00:00Z");
        double result = service.toMarsSolDate(zeroDayUtc);
        assertEquals(44_795.9998, result, 1e-3);
    }

    @DisplayName("Должен конвертировать пример с http://jtauber.github.io/mars-clock/")
    @Test
    void shouldConvertExampleFromGithub() {
        ZonedDateTime time = ZonedDateTime.parse("2020-05-01T09:44:43Z");
        double result = service.toMarsSolDate(time);
        assertEquals(52_018.84093, result, 1e-3);
    }
}
