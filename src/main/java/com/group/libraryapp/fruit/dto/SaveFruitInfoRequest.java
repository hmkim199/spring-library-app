package com.group.libraryapp.fruit.dto;

import java.time.LocalDate;

public class SaveFruitInfoRequest {
    private String name;
    private LocalDate warehousingDate;
    private long price;

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
