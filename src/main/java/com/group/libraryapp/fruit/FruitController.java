package com.group.libraryapp.fruit;

import com.group.libraryapp.fruit.dto.SalesAmountInfoResponse;
import com.group.libraryapp.fruit.dto.SaveFruitInfoRequest;
import com.group.libraryapp.fruit.dto.updateFruitStockRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruitInfo(@RequestBody SaveFruitInfoRequest request) {
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

}
