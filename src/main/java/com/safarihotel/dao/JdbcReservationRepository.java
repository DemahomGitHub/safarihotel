package com.safarihotel.dao;

import com.safarihotel.helper.FileReaderHelper;
import com.safarihotel.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Slf4j
@Repository
public class JdbcReservationRepository implements ReservationRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcReservationRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Reservation save(Reservation reservation) {
        int insertedRows=0;
        try {
            String sql = FileReaderHelper.getFileContent("sql/reservation_save.sql");
            log.info("Creating reservation");
            insertedRows = this.jdbc.update(
                sql,
                reservation.getId(),
                reservation.getFirstName(),
                reservation.getLastName(),
                reservation.getEmail(),
                reservation.getPhoneNumber(),
                reservation.getCheckInDt(),
                reservation.getCheckOutDt(),
                reservation.getReservedRoom().getId()
            );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (insertedRows == 1) {
            log.info("Reservation successfully created");
            return reservation;
        }
        log.info("Reservation creation failed");
        return null;
    }
}
