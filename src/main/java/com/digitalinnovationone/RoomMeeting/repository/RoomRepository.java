package com.digitalinnovationone.RoomMeeting.repository;

import com.digitalinnovationone.RoomMeeting.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
