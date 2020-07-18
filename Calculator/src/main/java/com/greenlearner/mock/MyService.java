package com.greenlearner.mock;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
public class MyService {

    ExternalService externalService;

    public MyService(ExternalService externalService) {
        this.externalService = externalService;
    }

    public boolean validate(String id){
        if(id ==null){
            throw new RuntimeException("id is null");
        }
        if(externalService.getValidationData(id) != null){
            return true;
        }

        return false;
    }
}
