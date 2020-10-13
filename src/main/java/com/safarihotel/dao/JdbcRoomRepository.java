package com.safarihotel.dao;

import com.safarihotel.helper.FileReaderHelper;
import com.safarihotel.helper.RowMapperHelper;
import com.safarihotel.model.Room;
import com.safarihotel.model.RoomImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Repository
public class JdbcRoomRepository implements RoomRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcRoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    public Iterable<Room> findAll() {
        try {
            String sql = FileReaderHelper.getFileContent("sql/room_find_all.sql");
            Iterable<Room> rooms = this.jdbc.query(sql, RowMapperHelper.mapRowToRoom);
            rooms.forEach(room -> {
                room.setImages(findRoomImages(room.getId()));
            });
            return rooms;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Room findById(Long id) {
        try {
            String sql = FileReaderHelper.getFileContent("sql/room_find_by_id.sql");
            Room  room = this.jdbc.queryForObject(sql, RowMapperHelper.mapRowToRoom, id);
            room.setImages(this.findRoomImages(room.getId()));
            return room;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<RoomImage> findRoomImages(Long roomId) {
        try {
            String sql = FileReaderHelper.getFileContent("sql/room_find_room_images.sql");
            return this.jdbc.query(sql, RowMapperHelper.mapRowToRoomImage, roomId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
