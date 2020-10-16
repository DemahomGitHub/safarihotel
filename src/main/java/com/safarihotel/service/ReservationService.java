package com.safarihotel.service;

import com.safarihotel.dao.JdbcReservationRepository;
import com.safarihotel.dao.JdbcRoomRepository;
import com.safarihotel.dao.ReservationRepository;
import com.safarihotel.dao.RoomRepository;
import com.safarihotel.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReservationService {
    private final ReservationRepository repository;

    @Autowired
    public ReservationService(JdbcReservationRepository repository) {
        this.repository = repository;
    }
    public Reservation save(Reservation reservation) {
        return this.repository.save(reservation);
    }
}
