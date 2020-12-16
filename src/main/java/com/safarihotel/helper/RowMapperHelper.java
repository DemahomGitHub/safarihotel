package com.safarihotel.helper;

import com.safarihotel.model.Room;
import com.safarihotel.model.RoomImage;
import com.safarihotel.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperHelper {
    public static RowMapper<Room> mapRowToRoom = new RowMapper<Room>() {
        @Override
        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            Room room = new Room();
            room.setId(rs.getLong("id"));
            room.setShortDescription(rs.getString("short_description"));
            room.setLongDescription(rs.getString("long_description"));
            room.setPricePerNight(rs.getBigDecimal("price_per_night"));
            room.setCreatedAt(rs.getTimestamp("created_at"));
            return room;
        }
    };

    public static RowMapper<RoomImage> mapRowToRoomImage = new RowMapper<RoomImage>() {
        @Override
        public RoomImage mapRow(ResultSet rs, int rowNum) throws SQLException {
            RoomImage roomImage = new RoomImage();
            roomImage.setId(rs.getLong("id"));
            roomImage.setFilePath(rs.getString("file_path"));
            roomImage.setRoomId(rs.getLong("room_id"));
            return roomImage;
        }
    };

    public static RowMapper<User> mapRowToUser = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("full_name"),
                rs.getBoolean("enabled")
            );
        }
    };
}
