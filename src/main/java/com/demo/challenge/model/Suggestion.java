package com.demo.challenge.model;

public class Suggestion {

    private String primary_line;
    private String city;
    private String state;

    public String getPrimary_line() {
        return primary_line;
    }

    public void setPrimary_line(String primary_line) {
        this.primary_line = primary_line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    private String zip_code;
}
