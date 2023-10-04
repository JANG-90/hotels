package com.example.hotels.controller;

import com.example.hotels.Reprository.HotelsRepository;
import com.example.hotels.dto.HotelForm;
import com.example.hotels.entity.Hotels;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
public class HotelController {

    @Autowired
    private HotelsRepository hotelsRepository;

    @GetMapping("/list")
    public String list(Model model) {
        ArrayList<Hotels> hotelsEntityList = hotelsRepository.findAll();
        model.addAttribute("hotellist", hotelsEntityList);
        return "index";
    }

    @GetMapping("/owner")
    public String owner() {
        return "owner";
    }

    @PostMapping("/create")
    public String user(HotelForm form) {
        System.out.println(form.toString());
        Hotels hotels = form.toEntity();
        Hotels saved = hotelsRepository.save(hotels);
        return "redirect:list/" + saved.getId();
    }

    @GetMapping("/list/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        Hotels hotelsEntity = hotelsRepository.findById(id).orElse(null);
        model.addAttribute("hotel", hotelsEntity);
        return "list";
    }

    @GetMapping("list/{id}/edit")
    public String edit(@PathVariable Long id,Model model){
        Hotels hotelsEntity = hotelsRepository.findById(id).orElse(null);
        model.addAttribute("hotel",hotelsEntity);
        return "edit";
    }

    @PostMapping("list/update")
    public String update(HotelForm form){
        Hotels hotelsEntity = form.toEntity();
        Hotels target = hotelsRepository.findById(hotelsEntity.getId()).orElse(null);
        if (target!= null){
            hotelsRepository.save(hotelsEntity);
        }
        return "redirect:" + hotelsEntity.getId();
    }

    @GetMapping("list/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes ppt){
        Hotels target = hotelsRepository.findById(id).orElse(null);
        if (target!=null){
            hotelsRepository.delete(target);
            ppt.addFlashAttribute("msg","삭제되었습니다");
        }
        return "redirect:/list";
    }
}
