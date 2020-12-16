package com.digitalinnovationone.RoomMeeting.controller;

import com.digitalinnovationone.RoomMeeting.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin; //permite que o front consuma nossa api backend.

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    
}
