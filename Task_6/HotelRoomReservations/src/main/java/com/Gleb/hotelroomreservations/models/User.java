package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    int id;

    boolean isAdmin;

    String login;

    String passw;
}