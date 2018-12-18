package com.crazyhotel.hotel.model;

import java.math.BigDecimal;

public class Hotel {

    private String fromDate;
    private String toDate;
    private String city;
    private Integer numberOfAdults;
    private String provider;
    private String hotelName;
    private BigDecimal farePerNight;
    private String [] amenities;
    private String rate;
    private String discount;

    public Hotel() {
    }

    public Hotel(String fromDate, String toDate, String city, Integer numberOfAdults, String provider, String hotelName, BigDecimal farePerNight, String [] amenities, String rate, String discount) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.city = city;
        this.numberOfAdults = numberOfAdults;
        this.provider = provider;
        this.hotelName = hotelName;
        this.farePerNight = farePerNight;
        this.amenities = amenities;
        this.rate = rate;
        this.discount = discount;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getCity() {
        return city;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public String getProvider() {
        return provider;
    }

    public String getHotelName() {
        return hotelName;
    }

    public BigDecimal getFarePerNight() {
        return farePerNight;
    }

    public String [] getAmenities() {
        return amenities;
    }

    public String getRate() {
        return rate;
    }

    public String getDiscount() {
        return discount;
    }

    public static class Builder {

        private String fromDate;
        private String toDate;
        private String city;
        private Integer numberOfAdults;
        private String provider;
        private String hotelName;
        private BigDecimal farePerNight;
        private String [] amenities;
        private String rate;
        private String discount;

        public Builder fromDate(String fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public Builder toDate(String toDate) {
            this.toDate = toDate;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder numberOfAdults(Integer numberOfAdults) {
            this.numberOfAdults = numberOfAdults;
            return this;
        }

        public Builder provider(String provider) {
            this.provider = provider;
            return this;
        }

        public Builder hotelName(String hotelName) {
            this.hotelName = hotelName;
            return this;
        }

        public Builder farePerNight(BigDecimal farePerNight) {
            this.farePerNight = farePerNight;
            return this;
        }

        public Builder amenities(String [] amenities) {
            this.amenities = amenities;
            return this;
        }

        public Builder rate(String rate) {
            this.rate = rate;
            return this;
        }

        public Builder discount(String discount) {
            this.discount = discount;
            return this;
        }

        public Hotel build() {
            return new Hotel(fromDate, toDate, city, numberOfAdults, provider, hotelName, farePerNight, amenities, rate, discount);
        }
    }
}
