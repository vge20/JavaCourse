package com.Gleb.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder {

    private int id;

    private int clientId;

    private String fullName;

    private String dateBirth;

    private boolean gender;

    private int carId;

    private String brand;

    private String color;

    private double engineCapacity;

    private String manufactureDate;

    private int price;

    private String orderDate;
}
