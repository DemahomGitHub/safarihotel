package com.safarihotel.controller;


import com.safarihotel.model.Room;
import com.safarihotel.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    String findAll(Model model) {
        log.info("Finding rooms");

        List<Room> rooms = roomService.findAll();
        model.addAttribute("rooms", rooms);

        log.info(rooms.size() + " rooms founds");
        return "rooms";
    }
}
