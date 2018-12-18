package com.crazyhotel.hotel.service;

import com.crazyhotel.hotel.repository.HotelRepository;
import com.crazyhotel.hotel.request.CrazyHotelRequest;
import com.crazyhotel.hotel.response.CrazyHotelResponse;
import com.crazyhotel.hotel.usecase.GetHotelUseCase;
import com.crazyhotel.hotel.usecase.GetHotelUseCaseImp;
import com.crazyhotel.hotel.validation.HotelValidation;

import java.util.Collection;

public class HotelServiceImp implements HotelService {

    private GetHotelUseCase getHotelUseCase;
    private HotelValidation validation = new HotelValidation();

    public HotelServiceImp(HotelRepository repository) {
        this.getHotelUseCase = new GetHotelUseCaseImp(repository);
    }

    public Collection<CrazyHotelResponse> getHotels(CrazyHotelRequest request) {
        validation.getHotelsRequestValidation(request);
        return getHotelUseCase.getHotels(request);
    }
}
