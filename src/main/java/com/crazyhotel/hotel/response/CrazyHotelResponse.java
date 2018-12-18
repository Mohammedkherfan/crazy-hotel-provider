package com.crazyhotel.hotel.response;

public class CrazyHotelResponse {

    private String hotelName;
    private String rate;
    private String price;
    private String discount;
    private String [] amenities;

    public CrazyHotelResponse() {
    }

    public CrazyHotelResponse(String hotelName, String rate, String price, String discount, String[] amenities) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.price = price;
        this.discount = discount;
        this.amenities = amenities;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String[] getAmenities() {
        return amenities;
    }

    public void setAmenities(String[] amenities) {
        this.amenities = amenities;
    }
}
