package com.crazyhotel.hotel.test;

import com.crazyhotel.hotel.controller.HotelController;
import com.crazyhotel.hotel.gateway.HotelGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HotelController.class)
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelGateway gateway;

    @Test
    public void whenGetListOfHotels_ThenShouldReturnListOfHotel() throws Exception {
        mockMvc.perform(get("/crazyHotel/2019-03-01T00:00:00.000Z/2019-03-01T00:00:00.000Z/AUH/1")).andExpect(status().isOk());
    }

}
