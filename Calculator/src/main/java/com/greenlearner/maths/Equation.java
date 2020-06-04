package com.greenlearner.maths;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
public class Equation {
    public static void main(String[] args) {
        int n1=100;
        int n2=2000;

        Calculator calculator = new Calculator();

        //equation = n1 + n2 * (n1 - n2) - (n1 / n2)
        int p2 = calculator.subtract(n1, n2);
        int p3 = calculator.divide(n1, n2);
        int a1 = calculator.multiply(n2, p2);
        int a2 = calculator.add(n1, a1);
        int result = calculator.subtract(a2, p3);

        System.out.println(result);
    }
}
