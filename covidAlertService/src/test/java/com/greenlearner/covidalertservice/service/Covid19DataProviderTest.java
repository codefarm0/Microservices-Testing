package com.greenlearner.covidalertservice.service;

import com.greenlearner.covidalertservice.dto.CountryData;
import com.greenlearner.covidalertservice.dto.CovidApiData;
import com.greenlearner.covidalertservice.dto.StateData;
import com.greenlearner.covidalertservice.dto.SummaryData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
 class Covid19DataProviderTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private Covid19DataProvider covid19DataProvider;

    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("state data provider test")
    void getStateDataTest() {

        when(restTemplate.getForObject(anyString(), any())).thenReturn(getCovidApiData());

        StateData delhi = covid19DataProvider.getStateData("Delhi");

        assertAll(
                () -> assertEquals("Delhi", delhi.getLoc()),
                () -> assertEquals(4, delhi.getDeaths()),
                () -> assertEquals(0, delhi.getConfirmedCasesForeign()),
                () -> assertEquals(1000, delhi.getConfirmedCasesIndian()),
                () -> assertEquals(4, delhi.getDischarged()),
                () -> assertEquals(1000, delhi.getTotalConfirmed())
        );
    }

    @Test
    @DisplayName("state data provider test - no data found")
    void getStateDataTestNoDataFoundForState() {

        when(restTemplate.getForObject(anyString(), any())).thenReturn(getCovidApiData());

        StateData maharashtra = covid19DataProvider.getStateData("Maharashtra");

        assertAll(
                () -> assertEquals(null, maharashtra.getLoc()),
                () -> assertEquals(0, maharashtra.getDeaths()),
                () -> assertEquals(0, maharashtra.getConfirmedCasesForeign()),
                () -> assertEquals(0, maharashtra.getConfirmedCasesIndian()),
                () -> assertEquals(0, maharashtra.getDischarged()),
                () -> assertEquals(0, maharashtra.getTotalConfirmed())
        );
    }

    @Test
    @DisplayName("summary data test")
    void getSummaryDataTest() {
        when(restTemplate.getForObject(anyString(), any())).thenReturn(getCovidApiDataForSummary());

        SummaryData data = covid19DataProvider.getSummaryData();

        assertAll(
                () -> assertEquals(5, data.getConfirmedButLocationUnidentified()),
                () -> assertEquals(100, data.getTotal()),
                () -> assertEquals(2, data.getDeaths()),
                () -> assertEquals(1, data.getDischarged()),
                () -> assertEquals(10, data.getConfirmedCasesForeign()),
                () -> assertEquals(90, data.getConfirmedCasesIndian()),
                () -> assertNotNull(data.getUpdateTime())
        );
    }

    private CovidApiData getCovidApiDataForSummary() {
        CovidApiData covidApiData = new CovidApiData();

        CountryData countryData = new CountryData();
        SummaryData summaryData = new SummaryData();
        summaryData.setTotal(100);
        summaryData.setDeaths(2);
        summaryData.setDischarged(1);
        summaryData.setConfirmedCasesIndian(90);
        summaryData.setConfirmedCasesForeign(10);
        summaryData.setUpdateTime(ZonedDateTime.now());
        summaryData.setConfirmedButLocationUnidentified(5);

        countryData.setSummary(summaryData);

        covidApiData.setData(countryData);
//        covidApiData.setSuccess(true);
        covidApiData.setLastRefreshed(ZonedDateTime.now());

        return covidApiData;
    }

    private CovidApiData getCovidApiData() {
        CovidApiData covidApiData = new CovidApiData();

        CountryData countryData = new CountryData();
       /* SummaryData summaryData = new SummaryData();
        summaryData.setTotal(100);
        summaryData.setDeaths(2);
        summaryData.setDischarged(1);
        summaryData.setConfirmedCasesIndian(90);
        summaryData.setConfirmedCasesForeign(10);
        summaryData.setUpdateTime(ZonedDateTime.now());

        countryData.setSummary(summaryData);*/

        StateData sd = new StateData();
        sd.setDeaths(4);
        sd.setLoc("Delhi");
        sd.setDischarged(4);
        sd.setConfirmedCasesIndian(1000);
        sd.setConfirmedCasesForeign(0);
        sd.setTotalConfirmed(1000);
        countryData.setRegional(new StateData[]{sd});

        covidApiData.setData(countryData);
/*
        covidApiData.setSuccess(true);
        covidApiData.setLastRefreshed(ZonedDateTime.now());*/
        return covidApiData;
    }
}
