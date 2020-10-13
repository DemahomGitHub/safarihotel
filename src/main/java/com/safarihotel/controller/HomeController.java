package com.safarihotel.controller;

import com.safarihotel.model.Room;
import com.safarihotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final RoomService roomService;

    @Autowired
    public HomeController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    String getHomePage(Model model) {
        List<Room> rooms = (List)roomService.findAll();

        model.addAttribute("rooms", rooms.stream().limit(3).collect(Collectors.toList()));

        return "index";
    }
}
