package com.wandoo.hotelreservation.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "room")
public class Room extends BaseEntity {

    @Column(name = "room_number", nullable = false)
    private int roomNumber;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "room_booking_period",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "period_id"))
    private Set<BookingPeriod> bookingPeriods = new HashSet<>();

    public int getRoomNumber() {
        return roomNumber;
    }

    public Room setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public Set<BookingPeriod> getBookingPeriods() {
        return bookingPeriods;
    }

    public Room setBookingPeriods(Set<BookingPeriod> bookingPeriods) {
        this.bookingPeriods = bookingPeriods;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Room.class.getSimpleName() + "[", "]")
                .add("roomNumber=" + roomNumber)
                .toString();
    }
}
