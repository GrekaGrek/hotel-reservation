package com.wandoo.hotelreservation.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name = "booking_period")
public class BookingPeriod extends BaseEntity {

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;
    @ManyToMany(mappedBy = "bookingPeriods", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Room> rooms = new HashSet<>();

    public LocalDate getFromDate() {
        return fromDate;
    }

    public BookingPeriod setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public BookingPeriod setToDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public BookingPeriod setRooms(Set<Room> rooms) {
        this.rooms = rooms;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookingPeriod that = (BookingPeriod) o;
        return Objects.equals(fromDate, that.fromDate) && Objects.equals(toDate, that.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fromDate, toDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BookingPeriod.class.getSimpleName() + "[", "]")
                .add("fromDate=" + fromDate)
                .add("toDate=" + toDate)
                .toString();
    }
}
