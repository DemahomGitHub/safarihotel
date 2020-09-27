package com.safarihotel.service;

import com.safarihotel.model.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoomService {
    List<Room> rooms = new ArrayList<>();

    @PostConstruct
    public void init() throws Exception {
        log.info("Fetching data");
        rooms.add(new Room(1L, "Chambre 2 lits tres spacieuse", "Ouverture sur le mont Kilimandjaro"));
        rooms.add(new Room(2L, "Chambre 1 lit  tres spacieuse", "Ouverture sur le mont Kilimandjaro"));
        rooms.add(new Room(3L, "Chambre 3 lits tres spacieuse", "Ouverture sur le mont Kilimandjaro"));
        rooms.add(new Room(4L, "Chambre 6 lits tres spacieuse", "Ouverture sur le mont Kilimandjaro"));
        rooms.add(new Room(5L, "Chambre 2 lits tres spacieuse", "Ouverture sur le mont Kilimandjaro"));
        rooms.add(new Room(6L, "Chambre 1 lit  tres spacieuse", "Ouverture sur le mont Kilimandjaro"));
        log.info("Fetching data done!");
    }

    public List<Room> findAll() {
        return this.rooms;
    }

    public Room findOne(Long id) {
        for (Room room : rooms) {
            if (room.getId().equals(id))
                return room;
        }
        return null;
    }
}
