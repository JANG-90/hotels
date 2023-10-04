package com.example.hotels.dto;

import com.example.hotels.entity.Hotels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor

public class HotelForm {
    private Long id;
    private String rooms;
    private String roomstatus;
    private String requestedterm;


    public Hotels toEntity(){
        return new Hotels(id,rooms,roomstatus,requestedterm);

    }

}
