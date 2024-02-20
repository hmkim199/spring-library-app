package com.group.libraryapp.calculator;

import com.group.libraryapp.calculator.dto.CalculateResponse;
import com.group.libraryapp.calculator.dto.CalculatorRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CalculatorController {

    @GetMapping("/api/v1/calc")
    public CalculateResponse getCalculateResult(CalculatorRequest request) {
        return new CalculateResponse(request.getNum1(), request.getNum2());
    }
}
