package com.example.hotels.service;

import com.example.hotels.entity.Hotels;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class HotelServiceTest {
    @Autowired
    HotelService hotelServie;

    @Test
    void list() {
        Hotels a = new Hotels(1L, '101호', '입실','aaa');
        Hotels b = new Hotels(2L, '102호', '퇴실','bbb');
        Hotels c = new Hotels(3L, '103호', '예약','ccc');
        List<Hotels> expected = new ArrayList<Hotels>(Arrays.asList(a, b, c));

        List<Hotels> articles = hotelServie.list();


    }
}