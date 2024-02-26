package com.group.libraryapp.fruit;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DynamicInsert
public class Fruit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String name;

    private long price;

    private LocalDate stocked_date;

    @ColumnDefault("1")
    private Integer stock;

    public Fruit(String name, long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.stocked_date = warehousingDate;
    }

    public Fruit() {

    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getStocked_date() {
        return stocked_date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
