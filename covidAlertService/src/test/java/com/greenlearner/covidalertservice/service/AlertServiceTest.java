package com.greenlearner.covidalertservice.service;

import com.greenlearner.covidalertservice.dto.AlertStatus;
import com.greenlearner.covidalertservice.dto.StateData;
import com.greenlearner.covidalertservice.dto.SummaryData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.ZonedDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
class AlertServiceTest {

    @InjectMocks
    private AlertService alertService;

    @Mock
    private Covid19DataProvider covid19DataProvider;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("When the total number of confirmed cases are less that 100")
    void getAlertAboutStateTestGreen(){
        StateData stateData = new StateData();
        stateData.setTotalConfirmed(999);

        when(covid19DataProvider.getStateData(ArgumentMatchers.anyString())).thenReturn(stateData);

        AlertStatus status = alertService.getAlertAboutState("Arunachal Pradesh");

        assertEquals("GREEN", status.getAlertLevel());
        assertEquals(Arrays.asList("Everything is Normal !!"), status.getMeasuresToBeTaken());
        assertEquals(stateData, status.getSummaryData());

        verify(covid19DataProvider, Mockito.times(1)).getStateData("Arunachal Pradesh");
    }

    @Test
    @DisplayName("When the total number of confirmed cases are less that 1005")
    void getAlertAboutStateTestOrange(){
        StateData stateData = new StateData();
        stateData.setTotalConfirmed(9999);

        when(covid19DataProvider.getStateData(ArgumentMatchers.anyString())).thenReturn(stateData);

        AlertStatus status = alertService.getAlertAboutState("uttar pradesh");

        assertEquals("ORANGE", status.getAlertLevel());
        assertEquals(Arrays.asList("Only Essential services are allowed", "List of services that come under essential service"), status.getMeasuresToBeTaken());
        assertEquals(stateData, status.getSummaryData());

        verify(covid19DataProvider).getStateData("uttar pradesh");
    }

    @Test
    @DisplayName("Boundry conditions")
    void getAlertAboutStateTestOrange2(){
        StateData stateData = new StateData();
        stateData.setTotalConfirmed(1001);

        when(covid19DataProvider.getStateData(ArgumentMatchers.anyString())).thenReturn(stateData);

        AlertStatus status = alertService.getAlertAboutState("uttar pradesh");

        assertEquals("ORANGE", status.getAlertLevel());
        assertEquals(Arrays.asList("Only Essential services are allowed", "List of services that come under essential service"), status.getMeasuresToBeTaken());
        assertEquals(stateData, status.getSummaryData());

        verify(covid19DataProvider).getStateData("uttar pradesh");
    }
    @Test
    @DisplayName("When the total number of confirmed cases are 10005")
    void getAlertAboutStateTestRed(){
        StateData stateData = new StateData();
        stateData.setTotalConfirmed(10005);

        when(covid19DataProvider.getStateData(ArgumentMatchers.anyString())).thenReturn(stateData);

        AlertStatus status = alertService.getAlertAboutState("Delhi");

        assertEquals("RED", status.getAlertLevel());
        assertEquals(Arrays.asList("Absolute lock-down", "Only Medical and food services are allowed here"), status.getMeasuresToBeTaken());
        assertEquals(stateData, status.getSummaryData());

        verify(covid19DataProvider).getStateData("Delhi");
    }


    @Test
    @DisplayName("Overall summary test")
    void getOverAllSummaryTest(){
        SummaryData summaryData = new SummaryData();
        summaryData.setUpdateTime(ZonedDateTime.now());
        summaryData.setConfirmedButLocationUnidentified(10);
        summaryData.setConfirmedCasesForeign(1);
        summaryData.setConfirmedCasesIndian(1000);
        summaryData.setDischarged(20);
        summaryData.setDeaths(2);
        summaryData.setTotal(1011);

        when(covid19DataProvider.getSummaryData()).thenReturn(summaryData);

        SummaryData actualSummary = alertService.getOverAllSummary();

        assertEquals(summaryData, actualSummary);

    }
}
