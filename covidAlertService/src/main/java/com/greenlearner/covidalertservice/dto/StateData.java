package com.greenlearner.covidalertservice.dto;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
public class StateData {
    private int confirmedCasesIndian;
    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private String loc;
    private int totalConfirmed;

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

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }
}
