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

        if (queryRes != null) { queryRes.close(); }
            if (statement != null) { statement.close(); }

        return car;
    }

    public void addCar(Car car) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("insert into cars (brand, color, engine_capacity, manufacture_date, price) "
                    + "values ('" + car.getBrand() + "', '" + car.getColor()
                    + "', " + car.getEngineCapacity() + ", '" + car.getManufactureDate()
                    + "', " + car.getPrice() + ")");

        if (statement != null) { statement.close(); }
    }

    public void updateCar(Car car) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("update cars set brand = '" + car.getBrand() + "', color = '" +
                    car.getColor() + "', engine_capacity = " + car.getEngineCapacity() + ", manufacture_date = '" +
                    car.getManufactureDate() + "', price = " + car.getPrice() + " where id = " + car.getId());

        if (statement != null) { statement.close(); }
    }

    public void deleteCar(int id) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("delete from cars where id = " + id);

        if (statement != null) { statement.close(); }
    }
}
