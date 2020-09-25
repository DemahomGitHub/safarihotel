package com.safarihotel.controller;

import com.safarihotel.model.Reservation;
import com.safarihotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    String read(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }

    @PostMapping
    String create(@Valid Reservation reservation, Errors errors) {
        log.info("Form validation");
        if (errors.hasErrors()) {
            log.info("Form contains errors");
            return "reservation";
        }
        log.info("Validation done!");
        log.info("Creating reservation");
        Reservation results = this.reservationService.create(reservation);
        log.info("Reservation created");

        return "redirect:/confirmation";
    }

}
