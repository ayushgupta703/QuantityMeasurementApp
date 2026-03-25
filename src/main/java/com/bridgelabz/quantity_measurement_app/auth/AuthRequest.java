package com.bridgelabz.quantity_measurement_app.auth;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;
}