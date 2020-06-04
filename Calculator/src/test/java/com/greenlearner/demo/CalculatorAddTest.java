package com.greenlearner.demo;

import com.greenlearner.maths.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.CacheRequest;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */

@DisplayName("Calculator Add test cases")
public class CalculatorAddTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Calculator Add test case - when both numbers are positive")
    void addTestCase1(){
        //sample data
        // expected data - 30
        int n1 = 10;
        int n2 =20;
        int expected = 30;
        int sum = calculator.add(n1, n2);

        Assertions.assertEquals(expected, sum);
    }

    @Test
    @DisplayName("Calculator Add test case - when both numbers are negative")
    void addTestCase2(){
        //sample data
        // expected data - 30
        int n1 = -10;
        int n2 =-20;
        int expected = -30;
        int sum = calculator.add(n1, n2);

        Assertions.assertEquals(expected, sum);
    }
}
