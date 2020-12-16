package com.digitalinnovationone.RoomMeeting.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="meetingroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="date", nullable = false)
    private String date;

    @Column(name="startHour", nullable = false)
    private String startHour;

    @Column(name = "endHour", nullable = false)
    private String endHour;

    public String toString(){
        return "Room[id="+id+", name="+name+", date="+date+", startHour="+startHour+", endHour="+endHour+"]";
    }
}
