package com.crazyhotel.hotel.usecase;

import com.crazyhotel.hotel.request.CrazyHotelRequest;
import com.crazyhotel.hotel.response.CrazyHotelResponse;

import java.util.Collection;

public interface GetHotelUseCase {

    Collection<CrazyHotelResponse> getHotels(CrazyHotelRequest request);
}
