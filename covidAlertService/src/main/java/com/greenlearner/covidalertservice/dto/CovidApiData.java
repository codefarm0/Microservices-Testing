package com.greenlearner.covidalertservice.dto;

import java.time.ZonedDateTime;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
public class CovidApiData {

//    private boolean success;

    private CountryData data;

   private ZonedDateTime lastRefreshed;

    private ZonedDateTime lastOriginUpdate;

//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }

    public CountryData getData() {
        return data;
    }

    public void setData(CountryData data) {
        this.data = data;
    }

    public ZonedDateTime getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(ZonedDateTime lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public ZonedDateTime getLastOriginUpdate() {
        return lastOriginUpdate;
    }

    public void setLastOriginUpdate(ZonedDateTime lastOriginUpdate) {
        this.lastOriginUpdate = lastOriginUpdate;
    }
}
