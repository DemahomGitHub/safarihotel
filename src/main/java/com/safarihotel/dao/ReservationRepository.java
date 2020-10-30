package com.safarihotel.dao;

import com.safarihotel.model.Reservation;

public interface ReservationRepository {
    public Reservation save(Reservation reservation);
}
