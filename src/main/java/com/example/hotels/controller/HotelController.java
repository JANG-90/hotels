package com.example.hotels.controller;

import com.example.hotels.Reprository.HotelsRepository;
import com.example.hotels.dto.HotelForm;
import com.example.hotels.entity.Hotels;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@Slf4j
public class HotelController {

    @Autowired
    private HotelsRepository hotelsRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Hotels> hotelsEntity = hotelsRepository.findAll();
        model.addAttribute("hotel",hotelsEntity);
        return "list";
    }

    @GetMapping("/owner")
    public String owner() {
        return "owner";
    }

    @PostMapping("/create")
    public String userw(HotelForm form) {
        System.out.println(form.toString());
        Hotels hotels = form.toEntity();
        Hotels saved = hotelsRepository.save(hotels);
        return "owner";
    }

    @GetMapping("/list/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        Hotels hotelsEntity = hotelsRepository.findById(id).orElse(null);
        model.addAttribute("hotel",hotelsEntity);
        return "/list";
    }
}
