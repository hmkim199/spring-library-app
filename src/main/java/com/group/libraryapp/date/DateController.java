package com.group.libraryapp.date;

import com.group.libraryapp.date.dto.CalculateSumRequest;
import com.group.libraryapp.date.dto.DayOfTheWeekResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class DateController {

    @GetMapping("/api/v1/day-of-the-week")
    public DayOfTheWeekResponse getDayOfTheWeek(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return new DayOfTheWeekResponse(localDate);
    }

    @PostMapping("/api/v1/sum")
    public int calculateSum(@RequestBody CalculateSumRequest request) {
        int sum = 0;
        List<Integer> numbers = request.getNumbers();
        for (Integer i : numbers) {
            sum += i.intValue();
        }
        return sum;
    }
}
