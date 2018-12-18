package com.crazyhotel.hotel.repository;

import com.crazyhotel.hotel.model.Hotel;
import com.crazyhotel.hotel.request.CrazyHotelRequest;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class HotelRepositoryImp implements HotelRepository {

    private Collection<Hotel> collection = new ArrayList<>();

    public HotelRepositoryImp() {
        collection.add(new Hotel.Builder()
            .fromDate("2019-01-01T00:00:00.000Z")
            .toDate("2019-12-31T00:00:00.000Z")
            .city("AUH")
            .numberOfAdults(10)
            .hotelName("Marriott Hotel")
            .farePerNight(new BigDecimal(100))
            .amenities(new String [] {"Wifi","parking","TV"})
            .rate("**,*****")
            .discount("0")
            .build()
        );

        collection.add(new Hotel.Builder()
                .fromDate("2019-05-01T00:00:00.000Z")
                .toDate("2019-12-31T00:00:00.000Z")
                .city("AUH")
                .numberOfAdults(10)
                .hotelName("Four Seasons Resort Dubai")
                .farePerNight(new BigDecimal(150))
                .amenities(new String [] {"Wifi","parking"})
                .rate("****,*****")
                .discount("10%")
                .build()
        );

        collection.add(new Hotel.Builder()
                .fromDate("2019-05-01T00:00:00.000Z")
                .toDate("2019-12-31T00:00:00.000Z")
                .city("DXB")
                .numberOfAdults(10)
                .hotelName("Four Seasons Resort Dubai")
                .farePerNight(new BigDecimal(150))
                .amenities(new String [] {"Wifi","parking","TV", "Smoking Room"})
                .rate("*****,*****")
                .discount("")
                .build()
        );
    }

    public Collection<Hotel> getHotels(CrazyHotelRequest request) {
        return  collection.stream().filter(
                (hotel -> ZonedDateTime.parse(hotel.getFromDate()).isBefore(ZonedDateTime.parse(request.getFrom())) &&
                        ZonedDateTime.parse(hotel.getToDate()).isAfter(ZonedDateTime.parse(request.getTo())) &&
                        hotel.getCity().equals(request.getCity()) &&
                        hotel.getNumberOfAdults() >= request.getAdultsCount())
        ).collect(Collectors.toList());

    }
}
