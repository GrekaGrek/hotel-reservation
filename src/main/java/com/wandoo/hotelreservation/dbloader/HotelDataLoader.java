package com.wandoo.hotelreservation.dbloader;

import com.wandoo.hotelreservation.domain.BookingPeriod;
import com.wandoo.hotelreservation.domain.Room;
import com.wandoo.hotelreservation.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class HotelDataLoader implements CommandLineRunner {

    private final HotelRepository repository;

    public HotelDataLoader(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Room room0 = new Room();
        room0.setRoomNumber(100);

        BookingPeriod bookingPeriod = new BookingPeriod();
        bookingPeriod.setFromDate(LocalDate.of(2022, 4, 1));
        bookingPeriod.setToDate(LocalDate.of(2022, 4, 10));
        bookingPeriod.getRooms().add(room0);

        room0.getBookingPeriods().add(bookingPeriod);

        repository.save(room0);

        Room room = new Room();
        room.setRoomNumber(101);

        BookingPeriod bookingPeriod0 = new BookingPeriod();
        bookingPeriod0.setFromDate(LocalDate.of(2022, 4, 3));
        bookingPeriod0.setToDate(LocalDate.of(2022, 4, 8));
        bookingPeriod0.getRooms().add(room);

        room.getBookingPeriods().add(bookingPeriod0);

        repository.save(room);

        Room room2 = new Room();
        room2.setRoomNumber(102);

        BookingPeriod bookingPeriod1 = new BookingPeriod();
        bookingPeriod1.setFromDate(LocalDate.of(2022, 4, 8));
        bookingPeriod1.setToDate(LocalDate.of(2022, 4, 18));
        bookingPeriod1.getRooms().add(room2);

        room2.getBookingPeriods().add(bookingPeriod1);

        repository.save(room2);
    }
}
