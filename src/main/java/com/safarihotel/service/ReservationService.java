package com.safarihotel.service;

import com.safarihotel.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReservationService {

    public Reservation create(Reservation reservation) {
        log.info("Reservation created" + reservation.toString());
        return reservation;
    }
}
