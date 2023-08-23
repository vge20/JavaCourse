package com.Gleb.BLObjects;

public class CustomerOrder {

    private int clientId;
    private int carId;
    private String orderDate;

    public CustomerOrder() {}

    public CustomerOrder(int clientId, int carId, String orderDate) {
        this.clientId = clientId;
        this.carId = carId;
        this.orderDate = orderDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
