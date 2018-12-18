package com.crazyhotel.hotel.test;

import com.crazyhotel.hotel.controller.HotelController;
import com.crazyhotel.hotel.exception.HotelException;
import com.crazyhotel.hotel.response.CrazyHotelResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { HotelTestConfiguration.class})
public class HotelUseCaseTest {

    @Autowired
    private HotelController controller;

    private String fromDate;
    private String toDate;
    private String city;
    private Integer numberOfAdults;

    @Before
    public void setUp() throws Exception {
        fromDate = "2019-02-05T00:00:00.000Z";
        toDate = "2019-02-11T00:00:00.000Z";
        city = "AUH";
        numberOfAdults = 3;
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelFromDateIsNull_ThenShouldPersistException() {
        controller.getHotels(null, toDate, city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelFromDateIsEmpty_ThenShouldPersistException() {
        controller.getHotels("", toDate, city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelFromDateIsSpace_ThenShouldPersistException() {
        controller.getHotels("   ", toDate, city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelFromDateFormatNotApplicableWithISODate_ThenShouldPersistException() {
        controller.getHotels("2019/01/30", toDate, city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelToDateIsNull_ThenShouldPersistException() {
        controller.getHotels(fromDate, null, city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelToDateIsEmpty_ThenShouldPersistException() {
        controller.getHotels(toDate, "", city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelToDateIsSpace_ThenShouldPersistException() {
        controller.getHotels(fromDate, "   ", city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelToDateFormatNotApplicableWithISODate_ThenShouldPersistException() {
        controller.getHotels(fromDate, "2019/01/30", city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelFromDateFormatBeforeCurrentDate_ThenShouldPersistException() {
        controller.getHotels("2018-12-01T00:00:00.000Z", toDate, city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelToDateFormatBeforeCurrentDate_ThenShouldPersistException() {
        controller.getHotels(fromDate, "2018-12-01T00:00:00.000Z", city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelFromDateAfterToDate_ThenShouldPersistException() {
        controller.getHotels("2019-02-27T00:00:00.000Z", "2019-02-01T00:00:00.000Z", city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelToDateBeforeFromDate_ThenShouldPersistException() {
        controller.getHotels("2019-03-01T00:00:00.000Z", "2019-02-01T00:00:00.000Z", city, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelCityIsNull_ThenShouldPersistException() {
        controller.getHotels(fromDate, toDate, null, numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelCityIsEmpty_ThenShouldPersistException() {
        controller.getHotels(fromDate, toDate, "", numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelCityIsSpace_ThenShouldPersistException() {
        controller.getHotels(fromDate, toDate, "   ", numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelCityNotValidWithIATACode_ThenShouldPersistException() {
        controller.getHotels(fromDate, toDate, "AUHO", numberOfAdults);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelNumberOfAdultsIsNull_ThenShouldPersistException() {
        controller.getHotels(fromDate, toDate, city, null);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelNumberEqualZero_ThenShouldPersistException() {
        controller.getHotels(fromDate, toDate, city, 0);
    }

    @Test(expected = HotelException.class)
    public void whenGetHotels_AndGetHotelNumberOfAdultsLessThanOneAdult_ThenShouldPersistException() {
        controller.getHotels(fromDate, toDate, city, -1);
    }

    @Test
    public void whenGetHotels_AndGetHotelAndFromDateNotExistInRepository_ThenShouldPersistEmptyList() {
        Collection<Resource<CrazyHotelResponse>> hotels = controller.getHotels("2018-12-30T00:00:00.000Z", toDate, city, numberOfAdults);
        assertTrue(hotels.isEmpty());
    }

    @Test
    public void whenGetHotels_AndGetHotelAndToDateNotExistInRepository_ThenShouldPersistEmptyList() {
        Collection<Resource<CrazyHotelResponse>> hotels = controller.getHotels(fromDate, "2020-01-01T00:00:00.000Z", city, numberOfAdults);
        assertTrue(hotels.isEmpty());
    }

    @Test
    public void whenGetHotels_AndGetHotelAndCityNotExistInRepository_ThenShouldPersistEmptyList() {
        Collection<Resource<CrazyHotelResponse>> hotels = controller.getHotels(fromDate, toDate, "AMN", numberOfAdults);
        assertTrue(hotels.isEmpty());
    }

    @Test
    public void whenGetHotels_AndGetHotelAndNumberOfAdultsNotExistInRepository_ThenShouldPersistEmptyList() {
        Collection<Resource<CrazyHotelResponse>> hotels = controller.getHotels(fromDate, toDate, city, 21);
        assertTrue(hotels.isEmpty());
    }

    @Test
    public void whenGetHotels_AndGetHotelWithValidData_ThenShouldPersistListFromRepository() {
        Collection<Resource<CrazyHotelResponse>> hotels = controller.getHotels(fromDate, toDate, city, numberOfAdults);
        assertTrue(!hotels.isEmpty());
    }

}

