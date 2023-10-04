package com.example.hotels.dto;

import com.example.hotels.entity.Hotels;

public class HotelForm {
    private String rooms;
    private String roomstatus;
    private String requestedterm;

    public HotelForm(String rooms, String requestedterm, String roomstatus) {
        this.rooms = rooms;
        this.requestedterm = requestedterm;
        this.roomstatus = roomstatus;
    }

    public Hotels toEntity(){
        return new Hotels(null,rooms,roomstatus,requestedterm);

    }

    @Override
    public String toString() {
        return "HotelForm{" +
                "rooms='" + rooms + '\'' +
                ", roomstatus='" + roomstatus + '\'' +
                ", requestedterm='" + requestedterm + '\'' +
                '}';
    }
}
