package com.greenlearner.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
class DemoTest {

    @Test
    void howToProtectFromCorona() {
        String expected = "stay home !! stay safe !!";
        Demo demo = new Demo();
        String actual = demo.howToProtectFromCorona();

        assertEquals(expected, actual, "both are not equal");
    }

    @Test
    void currentlyInfectedPeoples() {

        Demo demo = new Demo();

        int actual = demo.currentlyInfectedPeoples(100);

        int expected = 13100;

        assertEquals(expected, actual);
    }
}