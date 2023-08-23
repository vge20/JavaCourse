package com.Gleb.repositories;

import com.Gleb.entities.Car;
import com.Gleb.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarsRepository {

    public Car getCarById(int id) throws Exception {
        Car car = new Car();
        Statement statement = null;
        ResultSet queryRes = null;

        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            queryRes = statement.executeQuery("select * from cars c where c.id = " + id);

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
        }
        catch (Exception e) {
            throw new Exception();
        }

        try {
            if (queryRes != null) { queryRes.close(); }
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return car;
    }

    public void addCar(Car car) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("insert into cars (brand, color, engine_capacity, manufacture_date, price) "
                    + "values ('" + car.getBrand() + "', '" + car.getColor()
                    + "', " + car.getEngineCapacity() + ", '" + car.getManufactureDate()
                    + "', " + car.getPrice() + ")");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void updateCar(Car car) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("update cars set brand = '" + car.getBrand() + "', color = '" +
                    car.getColor() + "', engine_capacity = " + car.getEngineCapacity() + ", manufacture_date = '" +
                    car.getManufactureDate() + "', price = " + car.getPrice() + " where id = " + car.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void deleteCar(int id) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("delete from cars where id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }
}
