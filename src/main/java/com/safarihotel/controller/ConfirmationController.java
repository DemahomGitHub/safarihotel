package com.safarihotel.controller;

import com.safarihotel.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@SessionAttributes("reservation")
@RequestMapping("/confirmation")
public class ConfirmationController {

    @ModelAttribute
    public Reservation reservation(@ModelAttribute("reservation") Reservation reservation) {
        return reservation;
    }

    @GetMapping
    public String confirm(@ModelAttribute Reservation reservation) {
        return "confirmation";
    }
}
