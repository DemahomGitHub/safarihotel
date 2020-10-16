package com.safarihotel.controller;


import com.safarihotel.model.Room;
import com.safarihotel.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/rooms")
@SessionAttributes("room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Room> rooms = (List)roomService.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable Long id, Model model) {
        Optional<Room> room = Optional.ofNullable(roomService.findById(id));
        if (room.isPresent()) {
            model.addAttribute("room", room.get());
            return "room-details";
        } else {
            return "redirect:/error";
        }
    }
}
