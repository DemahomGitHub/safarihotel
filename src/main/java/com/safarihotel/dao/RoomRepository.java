package com.safarihotel.dao;

import com.safarihotel.model.Room;
import com.safarihotel.model.RoomImage;


public interface RoomRepository {
    public Iterable<Room> findAll();
    public Room findById(Long id);
    public Iterable<RoomImage> findRoomImages(Long roomId);
}
