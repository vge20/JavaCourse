package com.Gleb.repositories;

import com.Gleb.entities.Car;
import com.Gleb.DBConnection;

import java.sql.*;

public class CarsRepository implements Repository {

    private PreparedStatement createStatement(Car car, boolean isUpdate) throws SQLException {
        PreparedStatement statement;
        if (isUpdate) {
            statement = DBConnection.getConnection().prepareStatement(
                    "update cars set brand = ?, color = ?, engine_capacity = ?, " +
                            "manufacture_date = ?, price = ? where id = ?");
            statement.setInt(6, car.getId());
        }
        else {
            statement = DBConnection.getConnection().prepareStatement(
                    "insert into cars (brand, color, engine_capacity, manufacture_date, price) "
                    + "values (?, ?, ?, ?, ?)");
        }
        statement.setString(1, car.getBrand());
        statement.setString(2, car.getColor());
        statement.setDouble(3, car.getEngineCapacity());
        statement.setDate(4, Date.valueOf(car.getManufactureDate()));
        statement.setInt(5, car.getPrice());

        return statement;
    }

    public Car getCarById(int id) throws Exception {
        Car car = new Car();
        ResultSet queryRes = this.getEntityById("cars", id);

        if (queryRes.next()) {
            car.setId(queryRes.getInt("id"));
            car.setBrand(queryRes.getString("brand"));
            car.setColor(queryRes.getString("color"));
            car.setEngineCapacity(queryRes.getDouble("engine_capacity"));
            car.setManufactureDate(queryRes.getString("manufacture_date"));
            car.setPrice(queryRes.getInt("price"));
        }
        else {
            throw new Exception();
        }

        if (queryRes != null) { queryRes.close(); }

        return car;
    }

    public void addCar(Car car) throws SQLException {
        this.executeUpdateTable(this.createStatement(car, false));
    }

    public void updateCar(Car car) throws SQLException {
        this.executeUpdateTable(this.createStatement(car, true));
    }

    public void deleteCar(int id) throws SQLException {
        this.deleteEntityById("cars", id);
    }
}
