package com.esd.erp.placement.bean;

public class FilterValues {
    private String splVal;
    private String domVal;

    public FilterValues(String splVal, String domVal) {
        this.splVal = splVal;
        this.domVal = domVal;
    }

    public FilterValues() {
    }

    public String getSplVal() {
        return splVal;
    }

    public void setSplVal(String splVal) {
        this.splVal = splVal;
    }

    public String getDomVal() {
        return domVal;
    }

    public void setDomVal(String domVal) {
        this.domVal = domVal;
    }
}
