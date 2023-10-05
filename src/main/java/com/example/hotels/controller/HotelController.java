package com.example.hotels.controller;

import com.example.hotels.Reprository.HotelsRepository;
import com.example.hotels.dto.HotelForm;
import com.example.hotels.entity.Hotels;
import com.example.hotels.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;


@Controller
@Slf4j
public class HotelController {

    @Autowired
    private HotelsRepository hotelsRepository;
    @Autowired
    private HotelService service;

    @GetMapping("/list")
    public String list(Model model) {
        ArrayList<Hotels> hotellist = service.list();
        model.addAttribute("hotellist", hotellist);
        return "/index";
    }

    @GetMapping("/owner")
    public String owner() {
        return "owner";
    }

    @PostMapping("/create")
    public String user(HotelForm form) {
        Hotels hotels = form.toEntity();
        try {
            Hotels saved = service.user(form);
            return "redirect:list/" + saved.getId();
        } catch (Exception e) {
            return "redirect:list";
        }

    }

    @GetMapping("/list/{id}")
    public String show(@PathVariable Long id, Model model) {
        Hotels hotelsEntity = service.show(id);
        model.addAttribute("hotel", hotelsEntity);
        return "list";
    }

    @GetMapping("list/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Hotels hotelsEntity = service.edit(id);
        model.addAttribute("hotel", hotelsEntity);
        return "edit";
    }

    @PostMapping("list/update")
    public String update(HotelForm form) {
//        Hotels hotelEntity = form.toEntity();
//        Hotels target = hotelsRepository.findById(hotelEntity.getId()).orElse(null);
//        if (target != null) {
//            hotelsRepository.save(hotelEntity);
//        }
//        return "redirect:" + hotelEntity.getId();
        service.update(form);
        return "redirect:/list/" + form.getId();
    }

    @GetMapping("list/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes ppt) {
//        Hotels target = hotelsRepository.findById(id).orElse(null);
//        if (target != null) {
//            hotelsRepository.delete(target);
//            ppt.addFlashAttribute("msg", "삭제되었습니다");
//        }
//        return "redirect:/list";
        service.delete(id);
        ppt.addFlashAttribute("msg", "삭제되었습니다");
        return "redirect:/list";
    }
}
