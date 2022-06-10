package com.wandoo.hotelreservation.model;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class BookingPeriodDTO {

    private Long id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Set<RoomDTO> rooms = new HashSet<>();

    public Long getId() {
        return id;
    }

    public BookingPeriodDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public BookingPeriodDTO setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public BookingPeriodDTO setToDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public Set<RoomDTO> getRooms() {
        return rooms;
    }

    public BookingPeriodDTO setRooms(Set<RoomDTO> rooms) {
        this.rooms = rooms;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingPeriodDTO that = (BookingPeriodDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(fromDate, that.fromDate)
                && Objects.equals(toDate, that.toDate) && Objects.equals(rooms, that.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDate, toDate, rooms);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BookingPeriodDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("fromDate=" + fromDate)
                .add("toDate=" + toDate)
                .add("rooms=" + rooms)
                .toString();
    }
}
