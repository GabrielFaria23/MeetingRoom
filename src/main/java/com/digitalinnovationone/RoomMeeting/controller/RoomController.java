package com.digitalinnovationone.RoomMeeting.controller;

import com.digitalinnovationone.RoomMeeting.exception.ResourceNotFoundException;
import com.digitalinnovationone.RoomMeeting.model.Room;
import com.digitalinnovationone.RoomMeeting.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable long id) throws ResourceNotFoundException {
            Room room = verifyRoomExists(id, "Room not found with id: ");
            return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Validated @RequestBody Room room){
        return roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable long id, @Validated @RequestBody Room room) throws ResourceNotFoundException {
        Room roomToUpdate = verifyRoomExists(id, "Room not found with id: ");
        roomToUpdate.setName(room.getName());
        roomToUpdate.setDate(room.getDate());
        roomToUpdate.setStartHour(room.getStartHour());
        roomToUpdate.setEndHour(room.getEndHour());
        final Room updateRoom = roomRepository.save(roomToUpdate);
        return ResponseEntity.ok(updateRoom);
    }

    @DeleteMapping("/rooms/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, Boolean> deleteRoom(@PathVariable long id) throws ResourceNotFoundException {
        Room roomToDelete = verifyRoomExists(id, "Room not found with id: ");
        roomRepository.delete(roomToDelete);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private Room verifyRoomExists(@PathVariable long id, String s) throws ResourceNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(s + id));
    }
}
