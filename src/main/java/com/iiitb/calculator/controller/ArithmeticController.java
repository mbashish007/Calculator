package com.iiitb.calculator.controller;

import com.iiitb.calculator.dto.ArithmeticRequest;
import com.iiitb.calculator.dto.ArithmeticResponse;
import com.iiitb.calculator.service.ArithmeticService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/arithmetic")
@CrossOrigin
@RequiredArgsConstructor
public class ArithmeticController {


    private final ArithmeticService arithmeticService;

    @PostMapping
    public ResponseEntity<ArithmeticResponse> calculate(@RequestBody @Valid ArithmeticRequest request) {
        return ResponseEntity.ok(arithmeticService.calculateArithmetic(request));
    }

}
