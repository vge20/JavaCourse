package com.Gleb.BLObjects;

import java.sql.Date;

public class Client {

    private int id;
    private String fullName;
    private Date dateBirth;
    private boolean gender;

    public Client() {}

    public Client(int id, String fullName, Date dateBirth, boolean gender) {
        this.id = id;
        this.fullName = fullName;
        this.dateBirth = dateBirth;
        this.gender = gender;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
