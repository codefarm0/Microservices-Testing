package com.greenlearner.demo;

import com.greenlearner.maths.Calculator;
import com.greenlearner.maths.TooLargeNumbers;
import org.junit.jupiter.api.*;

import java.net.CacheRequest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */

@DisplayName("Calculator Add test cases")
public class CalculatorAddTest {

    private Calculator calculator = new Calculator();


    @Nested
    @DisplayName("All the positive cases")
    class PositiveCases {
        @Test
        @DisplayName("Calculator Add test case - when both numbers are positive")
        void addTestCase1() {
            //sample data
            // expected data - 30
            int n1 = 10;
            int n2 = 20;
            int expected = 30;
            int sum = calculator.add(n1, n2);

            assertEquals(expected, sum);
        }

        @Test
        @DisplayName("Calculator Add test case - when both numbers are negative")
        void addTestCase2() {
            //sample data
            // expected data - 30
            int n1 = -10;
            int n2 = -20;
            int expected = -30;
            int sum = calculator.add(n1, n2);

            assertEquals(expected, sum);
        }
    }

    @Nested
    @DisplayName("Exception cases")
    class ExceptionCases {
        @Test
        @DisplayName("Calculator Add test case - when  any number is less than -100")
        void addTestCase3() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> calculator.add(-101, 100));

            assertEquals("Numbers less than 100 are not allowed", exception.getMessage());
        }

        @Test
        @DisplayName("Calculator Add test case - when  any number is larger than 50000")
        void addTestCase4() {

            TooLargeNumbers exception = Assertions.assertThrows(TooLargeNumbers.class, () -> calculator.add(500001, 100));

            assertEquals("Negative Numbers not allowed", exception.getMessage());
        }
    }


    @Nested
    @DisplayName("TImout cases..")
    class TimeoutCases {

        @Test
        @DisplayName("Calculator Add test case - when  any number is larger than 40000 and taking time")
        @Timeout(value = 1100, unit = TimeUnit.MILLISECONDS)
        void addTestCase5() {

            int sum = calculator.add(41000, 41000);

            assertEquals(82000, sum);

        }

        @Test
        @DisplayName("Calculator Add test case - when  any number is larger than 40000 and taking time")
        void addTestCase6() {

            int sum = assertTimeout(Duration.ofMillis(1010), () -> calculator.add(42000, 42000));

            assertEquals(84000, sum);

        }

    }

    @Test
    @DisplayName("Assertion library demo")
    void addTestCase7() {

        assertTrue("str".equals("str"));
        assertFalse(false);

        String str = "arvind";
        assertNotNull(str);

        assertNotEquals(23, 43);

    }

    @Test
    @DisplayName("Calculator Add test case - assertAll")
    void addTestCase8() {

        assertAll("mulitple test cases",
                () -> assertEquals(46, calculator.add(23, 23)),
                () -> assertEquals(460, calculator.add(230, 230)),
                () -> assertEquals(8000, calculator.add(4000, 4000)));

    }

    @Nested
    @DisplayName("Repeate tests demo")
    class RepeatTestCases{

        @RepeatedTest(10)
        @DisplayName("Repeat test for timing info")
        void addTestCase1() {

            int sum = assertTimeout(Duration.ofMillis(1002), () -> calculator.add(42000, 42000));

            assertEquals(84000, sum);

        }
    }
}
