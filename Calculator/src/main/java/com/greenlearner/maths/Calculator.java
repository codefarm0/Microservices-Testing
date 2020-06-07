package com.greenlearner.maths;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
public class Calculator {

    public int add(int n1, int n2) {

        if(n1 < -100 || n2 < -100){
            throw new RuntimeException("Numbers less than 100 are not allowed");
        }

        if(n1 > 50000 || n2 > 50000){
            throw new TooLargeNumbers("Negative Numbers not allowed");
        }

        if(n1 > 40_000 && n2 > 40_000){
            System.out.println("Numners are too large.. It's going to take time");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return n1+n2;
    }

    public int subtract(int n1, int n2){
        if(n1<n2){
            return 0;
        }
        return n1-n2;
    }

    public int multiply(int n1, int n2){
        return n1*n2;
    }

    public int divide(int n1, int n2){
        if(n2==0){
            return 0;
        }
        return n1/n2;
    }
}
