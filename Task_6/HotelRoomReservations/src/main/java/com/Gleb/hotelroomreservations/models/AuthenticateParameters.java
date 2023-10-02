package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateParameters {

    private String login;

    @Setter
    private String password;
}
