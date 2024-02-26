package com.group.libraryapp.fruit;

import com.group.libraryapp.fruit.dto.SalesAmountInfoResponse;
import com.group.libraryapp.fruit.dto.SaveFruitInfoRequest;
import com.group.libraryapp.fruit.dto.updateFruitStockRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {

    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruitInfo(@RequestBody SaveFruitInfoRequest request) {
        String sql = "INSERT INTO fruit(name, price, stocked_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getPrice(), request.getWarehousingDate());
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruitStock(@RequestBody updateFruitStockRequest request) {
        String readSql = "SELECT stock FROM fruit WHERE id = ?";
        int stock = jdbcTemplate.queryForObject(readSql, Integer.class, request.getId());
        if (stock < 1) {
            throw new IllegalArgumentException();
        }
        String sql = "UPDATE fruit SET stock = stock - 1 where id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @GetMapping("/api/v1/fruit/stat")
    public SalesAmountInfoResponse selectSalesAmountInfo(@RequestParam String name) {
        long salesAmount = jdbcTemplate.queryForObject("SELECT SUM(price) FROM fruit WHERE name = ? AND  stock = 0", Long.class, name);
        long notSalesAmount = jdbcTemplate.queryForObject("SELECT SUM(price * stock) FROM fruit WHERE name = ? AND stock > 0", Long.class, name);

        return new SalesAmountInfoResponse(salesAmount, notSalesAmount);
    }

}
