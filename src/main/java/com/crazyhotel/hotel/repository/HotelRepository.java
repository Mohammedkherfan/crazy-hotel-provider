package com.crazyhotel.hotel.repository;

import com.crazyhotel.hotel.model.Hotel;
import com.crazyhotel.hotel.request.CrazyHotelRequest;

import java.util.Collection;

public interface HotelRepository {

    Collection<Hotel> getHotels(CrazyHotelRequest request);
}
