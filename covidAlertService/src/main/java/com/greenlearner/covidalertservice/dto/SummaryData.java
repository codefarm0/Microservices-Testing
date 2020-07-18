package com.greenlearner.covidalertservice.dto;

import java.time.ZonedDateTime;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
public class SummaryData {

    private int total;
    private int confirmedCasesIndian;
    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int confirmedButLocationUnidentified;

    private ZonedDateTime updateTime;

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(int confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public int getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(int confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }

    public int getDischarged() {
        return discharged;
    }

    public void setDischarged(int discharged) {
        this.discharged = discharged;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getConfirmedButLocationUnidentified() {
        return confirmedButLocationUnidentified;
    }

    public void setConfirmedButLocationUnidentified(int confirmedButLocationUnidentified) {
        this.confirmedButLocationUnidentified = confirmedButLocationUnidentified;
    }
}
