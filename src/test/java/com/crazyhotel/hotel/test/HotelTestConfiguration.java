package com.crazyhotel.hotel.test;

import com.crazyhotel.hotel.controller.HotelController;
import com.crazyhotel.hotel.controller.HotelControllerImp;
import com.crazyhotel.hotel.gateway.HotelGateway;
import com.crazyhotel.hotel.repository.HotelRepository;
import com.crazyhotel.hotel.repository.HotelRepositoryImp;
import com.crazyhotel.hotel.service.HotelService;
import com.crazyhotel.hotel.service.HotelServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelTestConfiguration {

    @Bean
    public HotelService getHotelService() {
        return new HotelServiceImp(getHotelRepository());
    }

    @Bean
    public HotelRepository getHotelRepository() {
        return new HotelRepositoryImp();
    }

    @Bean
    public HotelGateway getHotelGateway() {
        return new HotelGateway();
    }

    @Bean
    public HotelController getHotelController() {
        return new HotelControllerImp();
    }

}
