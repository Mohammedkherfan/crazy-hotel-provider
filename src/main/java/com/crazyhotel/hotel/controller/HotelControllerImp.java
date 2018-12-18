package com.crazyhotel.hotel.controller;

import com.crazyhotel.hotel.exception.HotelException;
import com.crazyhotel.hotel.gateway.HotelGateway;
import com.crazyhotel.hotel.hateoas.Hypermedia;
import com.crazyhotel.hotel.request.CrazyHotelRequest;
import com.crazyhotel.hotel.response.CrazyHotelResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(value = "/crazyHotel")
@Api(description = "Crazy hotel Application API (Get Hotel).")
public class HotelControllerImp implements HotelController {

    @Autowired
    private HotelGateway gateway;
    private Hypermedia hypermedia = new Hypermedia();

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{fromDate}/{toDate}/{city}/{numberOfAdults}", produces = {"application/hal+json"})
    @CrossOrigin()
    @ApiOperation(value = "Method to list hotels.", notes = "This method used when you want to list hotels.")
    public Collection<Resource<CrazyHotelResponse>> getHotels(@PathVariable String fromDate, @PathVariable String toDate, @PathVariable String city, @PathVariable Integer numberOfAdults) {
        try {
            Collection<Resource<CrazyHotelResponse>> resources = new ArrayList<>();
            gateway.getHotels(new CrazyHotelRequest(fromDate, toDate, city, numberOfAdults)).forEach(e -> {
                resources.add(hypermedia.getAccountResources(e));
            });
            return resources;
        }catch (Exception ex) {
            throw new HotelException(ex.getMessage());
        }
    }
}
