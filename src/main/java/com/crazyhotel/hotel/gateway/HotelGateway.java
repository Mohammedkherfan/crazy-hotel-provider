package com.crazyhotel.hotel.gateway;

import com.crazyhotel.hotel.request.CrazyHotelRequest;
import com.crazyhotel.hotel.response.CrazyHotelResponse;
import com.crazyhotel.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class HotelGateway {

    @Autowired
    private HotelService hotelService;

    public Collection<CrazyHotelResponse> getHotels(CrazyHotelRequest request) {
        return hotelService.getHotels(request);
    }
}
