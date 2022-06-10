package com.wandoo.hotelreservation.mapper;

import com.wandoo.hotelreservation.domain.BookingPeriod;
import com.wandoo.hotelreservation.domain.Room;
import com.wandoo.hotelreservation.model.BookingPeriodDTO;
import com.wandoo.hotelreservation.model.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoomMapper {

    private final BookingPeriodMapper bookingPeriodMapper;

    public RoomMapper(BookingPeriodMapper bookingPeriodMapper) {
        this.bookingPeriodMapper = bookingPeriodMapper;
    }

    public RoomDTO mapToDTO(Room room) {
        if(room == null) {
            return null;
        }

        return new RoomDTO()
                .setId(room.getId())
                .setRoomNumber(room.getRoomNumber())
                .setBookingPeriods(mapToDto(room.getBookingPeriods()));
    }

    public Room mapFromDTO(RoomDTO roomDTO) {
        if(roomDTO == null) {
            return null;
        }

        Room entity = new Room()
                .setRoomNumber(roomDTO.getRoomNumber())
                .setBookingPeriods(mapFromDto(roomDTO.getBookingPeriods()));

        entity.setId(roomDTO.getId());

        return entity;
    }

    private Set<BookingPeriodDTO> mapToDto(Set<BookingPeriod> bookingPeriods) {
        return bookingPeriods.stream()
                .map(bookingPeriodMapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    private Set<BookingPeriod> mapFromDto(Set<BookingPeriodDTO> bookingPeriodDTOs) {
        return bookingPeriodDTOs.stream()
                .map(bookingPeriodMapper::mapFromDTO)
                .collect(Collectors.toSet());
    }
}
