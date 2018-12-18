package com.crazyhotel.hotel;

import com.crazyhotel.hotel.gateway.HotelGateway;
import com.crazyhotel.hotel.repository.HotelRepository;
import com.crazyhotel.hotel.repository.HotelRepositoryImp;
import com.crazyhotel.hotel.service.HotelService;
import com.crazyhotel.hotel.service.HotelServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchConfiguration {

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
}
