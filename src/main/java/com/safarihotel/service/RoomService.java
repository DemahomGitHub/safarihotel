package com.safarihotel.service;

import com.safarihotel.dao.JdbcRoomRepository;
import com.safarihotel.dao.RoomRepository;
import com.safarihotel.model.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomService(JdbcRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Iterable<Room> findAll() {
        return this.roomRepository.findAll();
    }

    public Room findById(Long id) {
        return this.roomRepository.findById(id);
    }
}
