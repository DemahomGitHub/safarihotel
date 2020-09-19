package com.safarihotel.model;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Room {
    @NonNull
    private Long id;
    @NonNull
    private String imageTitle;
    @NonNull
    private String description;
}
