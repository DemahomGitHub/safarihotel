package com.safarihotel.model;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Room {
    private Long id;
    private Integer roomNumber;
    private String shortDescription;
    private String longDescription;
    private BigDecimal pricePerNight;
    private Timestamp createdAt;
    private Iterable<RoomImage> images;
}
