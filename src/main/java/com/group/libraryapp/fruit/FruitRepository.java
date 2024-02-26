package com.group.libraryapp.fruit;

import java.time.LocalDate;

public interface FruitRepository {
    public void saveFruitInfo(String name, long price, LocalDate stocked_date);

    public int selectStock(long id);

    public void updateFruitStock(long id);

    public long selectSalesAmount(String name);

    public long selectNotSalesAmount(String name);
}
