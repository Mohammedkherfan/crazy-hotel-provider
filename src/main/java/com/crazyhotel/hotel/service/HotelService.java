package com.crazyhotel.hotel.service;

import com.crazyhotel.hotel.request.CrazyHotelRequest;
import com.crazyhotel.hotel.response.CrazyHotelResponse;

import java.util.Collection;

public interface HotelService {

    Collection<CrazyHotelResponse> getHotels(CrazyHotelRequest request);
}
