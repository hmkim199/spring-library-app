package com.group.libraryapp.fruit;

import com.group.libraryapp.fruit.dto.SaveFruitInfoRequest;
import com.group.libraryapp.fruit.dto.updateFruitStockRequest;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruitInfo(SaveFruitInfoRequest request) {
        fruitRepository.saveFruitInfo(request.getName(), request.getPrice(), request.getWarehousingDate());
    }

    public void updateFruitStock(updateFruitStockRequest request) {
        if (fruitRepository.selectStock(request.getId()) < 1) {
            throw new IllegalArgumentException();
        }
        fruitRepository.updateFruitStock(request.getId());
    }

    public long selectSalesAmount(String name) {
        return fruitRepository.selectSalesAmount(name);
    }

    public long selectNotSalesAmount(String name) {
        return fruitRepository.selectNotSalesAmount(name);
    }
}
