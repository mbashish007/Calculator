package com.iiitb.calculator.service;

import com.iiitb.calculator.dto.ArithmeticRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
@SpringBootTest
class ArithmeticServiceTest {



    @Autowired
    private ArithmeticService arithmeticService;



    @Test
    void testAddition() {
        double output = arithmeticService.calculateArithmetic(new ArithmeticRequest(5.0, 3.0, "+")).output();
        assertEquals(8, output);
    }

    @Test
    void testSubtraction() {
        double output = arithmeticService.calculateArithmetic(new ArithmeticRequest(10.0, 4.0, "-")).output();
        assertEquals(6, output);
    }

    @Test
    void testMultiplication() {
        double output = arithmeticService.calculateArithmetic(new ArithmeticRequest(3.0, 4.0, "*")).output();
        assertEquals(12, output);
    }

    @Test
    void testDivision() {
        double output = arithmeticService.calculateArithmetic(new ArithmeticRequest(10.0, 2.0, "/")).output();
        assertEquals(5, output);
    }

    @Test
    void testSquareRoot() {
        double output = arithmeticService.calculateArithmetic(new ArithmeticRequest(25.0, null, "root")).output();
        assertEquals(5, output);
    }

    @Test
    void testLogarithm() {
        double output = arithmeticService.calculateArithmetic(new ArithmeticRequest(Math.E, null, "e")).output();
        assertEquals(1, output, 0.0001);
    }

    @Test
    void testFactorial() {
        double output = arithmeticService.calculateArithmetic(new ArithmeticRequest(5.0, null, "!")).output();
        assertEquals(120, output);
    }

    @Test
    void testPower() {
        double output = arithmeticService.calculateArithmetic(new ArithmeticRequest(2.0, 3.0, "^")).output();
        assertEquals(8, output);
    }

    @Test
    void testInvalidOperation() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> arithmeticService.calculateArithmetic(new ArithmeticRequest(5.0, 3.0, "%"))
        );
        assertEquals("Invalid operation: %", exception.getMessage());
    }
}