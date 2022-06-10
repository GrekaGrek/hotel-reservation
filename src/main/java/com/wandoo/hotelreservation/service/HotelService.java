package com.wandoo.hotelreservation.service;

import com.wandoo.hotelreservation.model.RoomDTO;

import java.time.LocalDate;
import java.util.Set;

public interface HotelService {

    Set<RoomDTO> checkAvailableRoomsForPeriod(LocalDate fromDate, LocalDate toDate);
}
