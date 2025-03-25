package com.iiitb.calculator.service;

import com.iiitb.calculator.dto.ArithmeticRequest;
import com.iiitb.calculator.dto.ArithmeticResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

@Service
public class ArithmeticService {


    private double calculate(double a, double b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            case "root" -> Math.pow(a, 0.5);
            case "e" -> Math.log(a);
            case "!" -> IntStream.rangeClosed(1, (int) Math.floor(a))
                    .reduce(1, (i, j) -> i * j);
            case "^" -> Math.pow(a, b);
            default -> throw new ArithmeticException("Invalid operation: " + operation);
        };

    }
    public ArithmeticResponse calculateArithmetic(ArithmeticRequest arithmeticRequest) {
        String op = arithmeticRequest.operation();
        double arg1 = arithmeticRequest.arg1();
        double arg2 = Objects.isNull(arithmeticRequest.arg2()) ? 0 : arithmeticRequest.arg2();
        return new ArithmeticResponse(calculate(arg1, arg2, op));
    }

    public Map<String, String> getAllOperations() {
        return Map.of("Addition  (arg1 + arg2)", "+",
                        "Subtraction (arg1 - arg2)", "-",
                        "Multiplication (arg1 * arg2)", "*",
                            "Division (arg1 / arg2)", "/",
                            "square root root(arg1)", "root",
                            "Natural logarithm (base е) - ln(x)", "e",
                            "Power Function (arg1^arg2)", "^",
                            "Factorial (arg1!)", "!"
                );
    }
}
