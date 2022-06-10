package com.wandoo.hotelreservation.service;

import com.wandoo.hotelreservation.model.RoomDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Set<RoomDTO> checkAvailableRoomsForPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public RoomDTO makeReservationForPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }
}
