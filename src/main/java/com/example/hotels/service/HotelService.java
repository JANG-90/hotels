package com.example.hotels.service;

import com.example.hotels.Reprository.HotelsRepository;
import com.example.hotels.dto.HotelForm;
import com.example.hotels.entity.Hotels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;


@Service

public class HotelService {
    @Autowired
    private HotelsRepository hotelsRepository;

    public ArrayList<Hotels> list() {

        return hotelsRepository.findAll();
    }

    public Hotels user(HotelForm form) {
        Hotels hotels = form.toEntity();
        return hotelsRepository.save(hotels);
    }

    public Hotels show(Long id) {

        return hotelsRepository.findById(id).orElse(null);
    }

    public Hotels edit(Long id) {

        return hotelsRepository.findById(id).orElse(null);
    }

}


