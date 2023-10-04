package com.example.hotels.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.Comment;

@Entity
public class Hotels {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String rooms;
    @Column
    private String roomstatus;
    @Column
    private String requestedterm;

    public Hotels(){

    }

    public Hotels(Long id, String rooms, String roomstatus, String requestedterm) {
        this.id = id;
        this.rooms = rooms;
        this.roomstatus = roomstatus;
        this.requestedterm = requestedterm;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "id=" + id +
                ", rooms='" + rooms + '\'' +
                ", roomstatus='" + roomstatus + '\'' +
                ", requestedterm='" + requestedterm + '\'' +
                '}';
    }
}
