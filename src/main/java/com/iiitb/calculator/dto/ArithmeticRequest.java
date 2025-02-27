package com.iiitb.calculator.dto;

//import org.jetbrains.annotations.NotNull;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ArithmeticRequest(
        @NotNull(message = "Argument 1 should be present")
        Double arg1,


        Double arg2,

        @NotEmpty(message = "Operation cannot be empty")
        @NotNull(message = "Operation is mandatory")
        String operation



) {
}
