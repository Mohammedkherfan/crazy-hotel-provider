package com.crazyhotel.hotel.request;

public class CrazyHotelRequest {

    private String from;
    private String to;
    private String city;
    private Integer adultsCount;

    public CrazyHotelRequest() {
    }

    public CrazyHotelRequest(String from, String to, String city, Integer adultsCount) {
        this.from = from;
        this.to = to;
        this.city = city;
        this.adultsCount = adultsCount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAdultsCount() {
        return adultsCount;
    }

    public void setAdultsCount(Integer adultsCount) {
        this.adultsCount = adultsCount;
    }
}
