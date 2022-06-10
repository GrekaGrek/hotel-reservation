package com.wandoo.hotelreservation.repository;

import com.wandoo.hotelreservation.domain.Room;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Room, Long> {

}
