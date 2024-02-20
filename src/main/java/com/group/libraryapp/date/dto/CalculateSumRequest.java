package com.group.libraryapp.date.dto;

import java.util.ArrayList;
import java.util.List;

public class CalculateSumRequest {
    private List<Integer> numbers;

    public CalculateSumRequest(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public CalculateSumRequest() {}

    public List<Integer> getNumbers() {
        return numbers;
    }
}
