package com.safarihotel.model;

import lombok.Data;

@Data
public class Reservation {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
