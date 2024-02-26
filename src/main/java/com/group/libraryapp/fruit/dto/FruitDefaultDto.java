package com.group.libraryapp.fruit.dto;

import com.group.libraryapp.fruit.Fruit;

import java.time.LocalDate;

public class FruitDefaultDto {
    private String name;
    private LocalDate warehousingDate;
    private long price;

    public FruitDefaultDto(Fruit fruit) {
        this.name = fruit.getName();
        this.warehousingDate = fruit.getStocked_date();
        this.price = fruit.getPrice();
    }

    public FruitDefaultDto() {

    }

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
