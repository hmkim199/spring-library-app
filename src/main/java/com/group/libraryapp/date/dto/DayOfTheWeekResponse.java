package com.group.libraryapp.date.dto;

import java.time.LocalDate;

public class DayOfTheWeekResponse {
    private String dayOfTheWeek;

    public DayOfTheWeekResponse(LocalDate localDate) {
        this.dayOfTheWeek = localDate.getDayOfWeek().name();
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
