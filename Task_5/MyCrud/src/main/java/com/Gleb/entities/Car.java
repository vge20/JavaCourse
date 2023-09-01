package com.Gleb.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private int id;

    private String brand;

    private String color;

    private double engineCapacity;

    private String manufactureDate;

    private int price;
}
