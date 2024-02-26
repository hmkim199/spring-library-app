package com.group.libraryapp.fruit;

import com.group.libraryapp.fruit.dto.FruitDefaultDto;
import com.group.libraryapp.fruit.dto.FruitPriceOption;
import com.group.libraryapp.fruit.dto.updateFruitStockRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruitInfo(FruitDefaultDto request) {
        //fruitRepository.saveFruitInfo(request.getName(), request.getPrice(), request.getWarehousingDate());
        fruitRepository.save(new Fruit(request.getName(), request.getPrice(), request.getWarehousingDate()));
    }

    public void updateFruitStock(updateFruitStockRequest request) {
//        if (fruitRepository.selectStock(request.getId()) < 1) {
//            throw new IllegalArgumentException();
//        }
//        fruitRepository.updateFruitStock(request.getId());
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow();
        int stock = fruit.getStock();
        if (stock < 1) {
            throw new IllegalArgumentException();
        }
        fruit.setStock(--stock);
        fruitRepository.save(fruit);
    }

    public long selectSalesAmount(String name) {
        //return fruitRepository.selectSalesAmount(name);
        return fruitRepository.findAllByName(name)
                .stream()
                .filter(fruit -> fruit.getStock() == 0)
                .map(fruit -> fruit.getPrice())
                .reduce(0L, Long::sum);
    }

    public long selectNotSalesAmount(String name) {
        //return fruitRepository.selectNotSalesAmount(name);
        return fruitRepository.findAllByName(name)
                .stream()
                .filter(fruit -> fruit.getStock() > 0)
                .map(fruit -> fruit.getStock() * fruit.getPrice())
                .reduce(0L, Long::sum);
    }

    public long selectCountFruitByName(String name) {
        return fruitRepository.findAllByName(name).size();
    }

    public List<FruitDefaultDto> selectFruitsByPriceOption(FruitPriceOption option, long price) {
        if (option.equals(FruitPriceOption.LTE)) {
            return fruitRepository.findAll()
                    .stream()
                    .filter(fruit -> fruit.getStock() > 0)
                    .filter(fruit -> fruit.getPrice() <= price)
                    .map(FruitDefaultDto::new)
                    .collect(Collectors.toList());
        }
        else if (option.equals(FruitPriceOption.GTE)) {
            return fruitRepository.findAll()
                    .stream()
                    .filter(fruit -> fruit.getStock() > 0)
                    .filter(fruit -> fruit.getPrice() >= price)
                    .map(FruitDefaultDto::new)
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException();
    }
}
