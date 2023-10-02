package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateParameters {

    private String login;

    private String password;
}
