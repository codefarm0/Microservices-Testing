package com.greenlearner.mocks;

import com.greenlearner.mock.ExternalService;
import com.greenlearner.mock.MyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */

public class MockitoDemo {

    @InjectMocks
    MyService myService;

    @Mock
//    @Spy
    ExternalService externalService;

    @BeforeEach
    void setup(){

        MockitoAnnotations.openMocks(this);

//        externalService = Mockito.mock(ExternalService.class);
//        externalService = Mockito.spy(ExternalService.class);

//        myService = new MyService(externalService);
    }

    @Test
    void test1(){
//        Mockito.when(externalService.getValidationData("arvind")).thenReturn("some-value");
        Mockito.when(externalService.getValidationData(anyString())).thenReturn("some-value");
        assertTrue(myService.validate("arvind123"));
//        Mockito.verify(externalService, Mockito.times(1)).getValidationData("arvind123");
        Mockito.verify(externalService, Mockito.times(1)).getValidationData(anyString());
    }

    @Test
    void test2(){
        Mockito.when(externalService.getValidationData("true")).thenReturn("true");
        Mockito.when(externalService.getValidationData(null)).thenReturn(null);
        Assertions.assertTrue(myService.validate("true"));

        assertThrows(RuntimeException.class, () -> myService.validate(null));

        Mockito.verify(externalService).getValidationData("true");
    }

    //when -then
    @Test
    void test3(){
        Mockito.when(externalService.getValidationData(null)).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> myService.validate(null));
    }

    //doretun and dothrow
    @Test
    void test4() {
        Mockito.doReturn("abc").when(externalService.getValidationData("abc"));
        Mockito.doThrow(RuntimeException.class).when(externalService.getValidationData(null));
    }

    // spy object
}
