package com.group.libraryapp.fruit;

import com.group.libraryapp.fruit.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruitInfo(@RequestBody FruitDefaultDto request) {
        fruitService.saveFruitInfo(request);
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruitStock(@RequestBody updateFruitStockRequest request) {
        fruitService.updateFruitStock(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public SalesAmountInfoResponse selectSalesAmountInfo(@RequestParam String name) {
        long salesAmount = fruitService.selectSalesAmount(name);
        long notSalesAmount = fruitService.selectNotSalesAmount(name);

        return new SalesAmountInfoResponse(salesAmount, notSalesAmount);
    }

    @GetMapping("/api/v1/fruit/count")
    public CountFruitByNameResponse selectCountFruitByName(@RequestParam String name) {
        return new CountFruitByNameResponse(fruitService.selectCountFruitByName(name));
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitDefaultDto> selectFruitsByPriceOption(@RequestParam("option") FruitPriceOption option, @RequestParam long price) {
        return fruitService.selectFruitsByPriceOption(option, price);
    }
}
