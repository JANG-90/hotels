package com.example.hotels.Reprository;

import com.example.hotels.entity.Hotels;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface HotelsRepository extends CrudRepository<Hotels,Long> {
    @Override
    ArrayList<Hotels> findAll();
}
