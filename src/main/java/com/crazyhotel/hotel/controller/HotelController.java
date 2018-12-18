package com.crazyhotel.hotel.controller;

import com.crazyhotel.hotel.response.CrazyHotelResponse;
import org.springframework.hateoas.Resource;

import java.util.Collection;

public interface HotelController {

    Collection<Resource<CrazyHotelResponse>> getHotels(String fromDate, String toDate, String city, Integer numberOfAdults);
}
