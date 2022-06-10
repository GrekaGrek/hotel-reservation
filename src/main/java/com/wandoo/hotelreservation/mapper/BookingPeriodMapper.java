package com.wandoo.hotelreservation.mapper;

import com.wandoo.hotelreservation.domain.BookingPeriod;
import com.wandoo.hotelreservation.domain.Room;
import com.wandoo.hotelreservation.model.BookingPeriodDTO;
import com.wandoo.hotelreservation.model.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookingPeriodMapper {

    private final RoomMapper roomMapper;

    public BookingPeriodMapper(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    public BookingPeriodDTO mapToDTO(BookingPeriod period) {
        if (period == null) {
            return null;
        }

        return new BookingPeriodDTO()
                .setId(period.getId())
                .setToDate(period.getToDate())
                .setFromDate(period.getFromDate())
                .setRooms(mapToDto(period.getRooms()));
    }

    public BookingPeriod mapFromDTO(BookingPeriodDTO periodDTO) {
        if (periodDTO == null) {
            return null;
        }

        BookingPeriod entity = new BookingPeriod()
                .setToDate(periodDTO.getToDate())
                .setFromDate(periodDTO.getFromDate())
                .setRooms(mapFromDto(periodDTO.getRooms()));

        entity.setId(periodDTO.getId());

        return entity;
    }

    private Set<RoomDTO> mapToDto(Set<Room> rooms) {
        return rooms.stream()
                .map(roomMapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    private Set<Room> mapFromDto(Set<RoomDTO> roomDTOs) {
        return roomDTOs.stream()
                .map(roomMapper::mapFromDTO)
                .collect(Collectors.toSet());
    }
}
