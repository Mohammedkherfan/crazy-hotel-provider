package com.crazyhotel.hotel.usecase;

import com.crazyhotel.hotel.exception.HotelException;
import com.crazyhotel.hotel.repository.HotelRepository;
import com.crazyhotel.hotel.request.CrazyHotelRequest;
import com.crazyhotel.hotel.response.CrazyHotelResponse;

import java.util.ArrayList;
import java.util.Collection;

public class GetHotelUseCaseImp implements GetHotelUseCase {

    private HotelRepository repository;

    public GetHotelUseCaseImp(HotelRepository repository) {
        this.repository = repository;
    }

    public Collection<CrazyHotelResponse> getHotels(CrazyHotelRequest request) {
        try {
            Collection<CrazyHotelResponse> hotels = new ArrayList<>();
            repository.getHotels(request).forEach(e -> {
                hotels.add(new CrazyHotelResponse(e.getHotelName(), e.getRate(), String.valueOf(e.getFarePerNight()), e.getDiscount(), e.getAmenities()));
            });
            return hotels;
        }catch (Exception ex) {
            throw new HotelException(ex.getMessage());
        }
    }
}
