package com.crazyhotel.hotel.validation;

import com.crazyhotel.hotel.exception.HotelException;
import com.crazyhotel.hotel.request.CrazyHotelRequest;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

public class HotelValidation {

    public void getHotelsRequestValidation(CrazyHotelRequest request) {
        this.fromDateValidation.validate(request.getFrom());
        this.toDateValidation.validate(request.getTo());
        this.fromDateFormatValidation.validate(request.getFrom());
        this.toDateFormatValidation.validate(request.getTo());
        this.fromDateWithCurrentValidation.validate(request.getFrom());
        this.toDateWithCurrentValidation.validate(request.getTo());
        this.cityValidation.validate(request.getCity());
        this.cityIATAValidation.validate(request.getCity());
        this.numberOfAdultsValidation.validate(request.getAdultsCount());
        this.numberOfAdultsGreaterThenZeroValidation.validate(request.getAdultsCount());
        checkFromAndToDate(request.getFrom(), request.getTo());
    }

    @FunctionalInterface
    public interface Validation<T> {
        void validate(T value);
    }

    private Validation<String> fromDateValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new HotelException("Invalid hotel from date - hotel from date is null or empty");
        }
    });

    private Validation<String> toDateValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new HotelException("Invalid hotel to date - hotel to date is null or empty");
        }
    });

    private Validation<String> fromDateFormatValidation = (value -> {
        if (!checkDateFormatIsValid(value)) {
            throw new HotelException("Invalid hotel from date - hotel from date not applicable with ISO date format");
        }
    });

    private Validation<String> toDateFormatValidation = (value -> {
        if (!checkDateFormatIsValid(value)) {
            throw new HotelException("Invalid hotel from date - - hotel to date not applicable with ISO date format");
        }
    });

    private Validation<String> fromDateWithCurrentValidation = (value -> {
        if (ZonedDateTime.parse(value).isBefore(ZonedDateTime.now())) {
            throw new HotelException("Invalid hotel from date - hotel from can not before current date");
        }
    });

    private Validation<String> toDateWithCurrentValidation = (value -> {
        if (ZonedDateTime.parse(value).isBefore(ZonedDateTime.now())) {
            throw new HotelException("Invalid hotel to date - hotel to can not before current date");
        }
    });

    private Validation<String> cityValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new HotelException("Invalid hotel city - city is null or empty");
        }
    });

    private Validation<String> cityIATAValidation = (value -> {
        IATACodeValidation validation = new IATACodeValidation();
        if (!validation.validate(value)) {
            throw new HotelException("Invalid hotel city - city not match with IATA RegEx");
        }
    });

    private Validation<Integer> numberOfAdultsValidation = (value -> {
        if (isNull(value)) {
            throw new HotelException("Invalid hotel number of adults - number of adults is null");
        }
    });

    private Validation<Integer> numberOfAdultsGreaterThenZeroValidation = (value -> {
        if (value < 1) {
            throw new HotelException("Invalid hotel number of adults - minimum number of adults shall be one");
        }
    });

    private Boolean checkDateFormatIsValid(String date) {
        try {
            ZonedDateTime.parse(date).format(DateTimeFormatter.ISO_INSTANT);
            return Boolean.TRUE;
        }catch (Exception ex) {
            return Boolean.FALSE;
        }
    }

    private void checkFromAndToDate(String fromDate, String toDate) {
        if (ZonedDateTime.parse(fromDate).isAfter(ZonedDateTime.parse(toDate)) || ZonedDateTime.parse(toDate).isBefore(ZonedDateTime.parse(fromDate)))
            throw new HotelException("Invalid from or to date, maybe from date is after to date or else");
    }
}
