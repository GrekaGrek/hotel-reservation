package com.wandoo.hotelreservation.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class RoomDTO {

    private Long id;
    private int roomNumber;
    private Set<BookingPeriodDTO> bookingPeriods = new HashSet<>();

    public Long getId() {
        return id;
    }

    public RoomDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomDTO setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public Set<BookingPeriodDTO> getBookingPeriods() {
        return bookingPeriods;
    }

    public RoomDTO setBookingPeriods(Set<BookingPeriodDTO> bookingPeriods) {
        this.bookingPeriods = bookingPeriods;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDTO roomDTO = (RoomDTO) o;
        return roomNumber == roomDTO.roomNumber && Objects.equals(bookingPeriods, roomDTO.bookingPeriods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, bookingPeriods);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RoomDTO.class.getSimpleName() + "[", "]")
                .add("roomNumber=" + roomNumber)
                .add("bookingPeriods=" + bookingPeriods)
                .toString();
    }
}
