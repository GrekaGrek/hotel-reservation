package com.wandoo.hotelreservation.service;

import com.wandoo.hotelreservation.model.RoomDTO;

import java.time.LocalDate;
import java.util.Set;

public interface AdministratorService extends HotelService {

    RoomDTO saveRoom(RoomDTO roomDTO);

    Set<RoomDTO> findAllRooms();

    RoomDTO findRoom(Long id);

    RoomDTO updateRoom(Long id, RoomDTO roomDTO);

    void deleteRoom(Long id);

    Set<RoomDTO> checkBookedRoomsForPeriod(LocalDate fromDate, LocalDate toDate);
}
