package com.greenlearner.covidalertservice.dto;

/**
 * @author - GreenLearner(https://www.youtube.com/c/greenlearner)
 */
public class StateData  extends BaseDataClass{
    private String loc;
    private int totalConfirmed;

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
