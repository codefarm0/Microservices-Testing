package com.greenlearner.covidalertservice.service;

import com.greenlearner.covidalertservice.dto.CovidApiData;
import com.greenlearner.covidalertservice.dto.StateData;
import com.greenlearner.covidalertservice.dto.SummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */

@Service
public class Covid19DataProvider {

    final String url = "https://api.rootnet.in/covid19-in/stats/latest";

    @Autowired
    RestTemplate restTemplate;

    public StateData getStateData(String state) {

        CovidApiData covidApiData = restTemplate.getForObject(url, CovidApiData.class);

        return Arrays.stream(covidApiData.getData().getRegional())
                .filter(e -> e.getLoc().equalsIgnoreCase(state))
                .findAny()
                .orElse(new StateData());

    }

    public SummaryData getSummaryData() {
        CovidApiData covidApiData = restTemplate.getForObject(url, CovidApiData.class);

        SummaryData summaryData = covidApiData.getData().getSummary();

        summaryData.setUpdateTime(covidApiData.getLastRefreshed());

        return summaryData;
    }
}
