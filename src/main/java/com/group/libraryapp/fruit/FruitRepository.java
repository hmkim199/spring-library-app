package com.group.libraryapp.fruit;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    //public void saveFruitInfo(String name, long price, LocalDate stocked_date);
//
//    public int selectStock(long id);
//
//    public void updateFruitStock(long id);
//
//    public long selectSalesAmount(String name);
//
//    public long selectNotSalesAmount(String name);

    public List<Fruit> findAllByName(String name);
}
