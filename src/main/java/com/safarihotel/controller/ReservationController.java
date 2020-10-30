package com.safarihotel.controller;

import com.safarihotel.model.Reservation;
import com.safarihotel.model.Room;
import com.safarihotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Controller
@SessionAttributes({"room", "reservation"})
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    String read(Model model, @ModelAttribute("room") Room room) {
        model.addAttribute("room", room);
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }

    @PostMapping
    String create(@Valid Reservation reservation, Errors errors, @ModelAttribute("room") Room room, Model model) {
        if (errors.hasErrors()) {
            return "reservation";
        }

        reservation.setReservedRoom(room);
        reservation.setId(new Random().nextLong());
        Optional<Reservation> results = Optional.ofNullable(this.reservationService.save(reservation));

        if (results.isPresent()) {
            model.addAttribute("reservation", reservation);
            return "redirect:/confirmation";
        }
        return "reservation";
    }

}
