package com.greenlearner.demo;

import com.greenlearner.maths.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */

public class ParameterizedDemoTest {

    @ParameterizedTest
//    @EmptySource
//    @NullSource
//    @NullAndEmptySource
    @ValueSource(strings = {"abc", "defc", "xyz"})
    void testCase1(String arg) {

        Assertions.assertTrue(!arg.isEmpty());
    }

    Calculator calculator = new Calculator();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34, 5, 6})
    void testCase2(int arg) {

        Assertions.assertTrue(calculator.isSumAllowed(arg));
    }

    @ParameterizedTest
    @MethodSource("intRange")
    void testCase3(int arg) {

        Assertions.assertTrue(calculator.isSumAllowed(arg));
    }

    static IntStream intRange() {
        return IntStream.range(10, 40);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "11, 20, 31",
            "12, 20, 32",
            "13, 20, 33"
    })
    void testCase4(int num1, int num2, int expected) {
        assertEquals(expected, calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase5(int num1, int num2, int expected) {
        assertEquals(expected, calculator.add(num1, num2));
    }

}
