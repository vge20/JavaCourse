package com.Gleb.repositories;

import com.Gleb.entities.Car;

import java.sql.*;

public class CarsRepository implements Repository {

    @Override
    public PreparedStatement createStatement(Object entity, boolean isUpdate,
                                             Connection connection) throws SQLException {
        Car car = (Car) entity;
        PreparedStatement statement;
        if (isUpdate) {
            statement = connection.prepareStatement(
                    "update cars set brand = ?, color = ?, engine_capacity = ?, " +
                            "manufacture_date = ?, price = ? where id = ?");
            statement.setInt(6, car.getId());
        }
        else {
            statement = connection.prepareStatement(
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

    @Override
    public Object getById(int id) throws SQLException {
        Car car = new Car();
        PreparedStatement statement = null;
        ResultSet queryRes = this.getEntityById("cars", id, statement);

        if (queryRes.next()) {
            car.setId(queryRes.getInt("id"));
            car.setBrand(queryRes.getString("brand"));
            car.setColor(queryRes.getString("color"));
            car.setEngineCapacity(queryRes.getDouble("engine_capacity"));
            car.setManufactureDate(queryRes.getString("manufacture_date"));
            car.setPrice(queryRes.getInt("price"));
        }
        else {
            return null;
        }

        if (statement != null) { statement.close(); }
        if (queryRes != null) { queryRes.close(); }

        return car;
    }

    @Override
    public void delete(int id) throws SQLException {
        this.deleteEntityById("cars", id);
    }
}
