package com.wandoo.hotelreservation.service;

import com.wandoo.hotelreservation.domain.Room;
import com.wandoo.hotelreservation.mapper.RoomMapper;
import com.wandoo.hotelreservation.model.RoomDTO;
import com.wandoo.hotelreservation.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdministratorService {

    private final HotelRepository repository;
    private final RoomMapper mapper;

    public AdminServiceImpl(HotelRepository repository, RoomMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RoomDTO saveRoom(RoomDTO roomDTO) {
        var room = mapper.mapFromDTO(roomDTO);
        var savedRoom = repository.save(room);

        return mapper.mapToDTO(savedRoom);
    }

    @Override
    public Set<RoomDTO> findAllRooms() {
        Set<Room> rooms = new HashSet<>();
        repository.findAll().forEach(rooms::add);

        return rooms.stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        var optionalRoom = repository.findById(id);

        if (optionalRoom.isEmpty()) {
            throw new RuntimeException("Room is not found");
        }

        var room = mapper.mapFromDTO(roomDTO);
        var savedRoom = repository.save(room);

        return mapper.mapToDTO(savedRoom);
    }

    @Override
    public RoomDTO findRoom(Long id) {
        var room = repository.findById(id).orElse(null);

        return mapper.mapToDTO(room);
    }

    @Override
    public void deleteRoom(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Set<RoomDTO> checkBookedRoomsForPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public Set<RoomDTO> checkAvailableRoomsForPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }
}
