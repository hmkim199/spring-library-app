//package com.group.libraryapp.fruit;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//
//@Primary
//@Repository
//public class FruitMySqlRepository implements FruitRepository{
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void saveFruitInfo(String name, long price, LocalDate stocked_date) {
//        String sql = "INSERT INTO fruit(name, price, stocked_date) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, name, price, stocked_date);
//    }
//
//    public int selectStock(long id) {
//        String readSql = "SELECT stock FROM fruit WHERE id = ?";
//        return jdbcTemplate.queryForObject(readSql, Integer.class, id);
//    }
//
//    public void updateFruitStock(long id) {
//        String sql = "UPDATE fruit SET stock = stock - 1 where id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    public long selectSalesAmount(String name) {
//        return jdbcTemplate.queryForObject("SELECT SUM(price) FROM fruit WHERE name = ? AND  stock = 0", Long.class, name);
//    }
//
//    public long selectNotSalesAmount(String name) {
//        return jdbcTemplate.queryForObject("SELECT SUM(price * stock) FROM fruit WHERE name = ? AND stock > 0", Long.class, name);
//    }
//}
