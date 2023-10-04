package com.example.hotels.Reprository;

import com.example.hotels.entity.Hotels;
import org.springframework.data.repository.CrudRepository;

public interface HotelsRepository extends CrudRepository<Hotels,Long> {
}
