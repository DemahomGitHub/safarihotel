package com.safarihotel.model;

import lombok.Data;

@Data
public class RoomImage {
    private Long id;
    private String filePath;
    private Long roomId;
}
