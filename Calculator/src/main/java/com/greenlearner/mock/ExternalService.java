package com.greenlearner.mock;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
public class ExternalService {

    public String getValidationData(String id){
        return "actual data for validation";
    }

    void someMethod() throws RuntimeException{
        System.out.println("doing nothing..");
    }
}
