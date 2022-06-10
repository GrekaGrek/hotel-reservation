package com.wandoo.hotelreservation.service;

import com.wandoo.hotelreservation.model.RoomDTO;

import java.time.LocalDate;

public interface CustomerService extends HotelService {

    RoomDTO makeReservationForPeriod(LocalDate fromDate, LocalDate toDate);
}
