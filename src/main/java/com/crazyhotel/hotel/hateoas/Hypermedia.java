package com.crazyhotel.hotel.hateoas;

import com.crazyhotel.hotel.controller.HotelControllerImp;
import com.crazyhotel.hotel.response.CrazyHotelResponse;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static java.util.Objects.isNull;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class Hypermedia {

    public Resource getAccountResources(CrazyHotelResponse response) {
        Resource resource = null;
        if (!isNull(response)) {
            resource = new Resource(response);
            resource.add(ControllerLinkBuilder.linkTo(methodOn(HotelControllerImp.class).getHotels("", "", "", 0)).withSelfRel().withType("GET"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new CrazyHotelResponse());
    }
}
