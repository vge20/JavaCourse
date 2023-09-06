package com.Gleb.repositories;

import com.Gleb.TypeOfUpdate;
import com.Gleb.entities.CustomerOrder;

import java.sql.*;

public class CustomerOrdersRepository implements Repository {

    @Override
    public PreparedStatement createStatement(Object entity, TypeOfUpdate typeOfUpdate,
                                             Connection connection) throws SQLException {
        CustomerOrder customerOrder = (CustomerOrder) entity;
        PreparedStatement statement;

        if (typeOfUpdate != TypeOfUpdate.ADD_WITH_ID) {
            if (typeOfUpdate == TypeOfUpdate.UPDATE) {
                statement = connection.prepareStatement(
                        "update customer_orders set client_id = ?, car_id = ?, order_date = ? where id = ?");
                statement.setInt(4, customerOrder.getId());
            } else {
                statement = connection.prepareStatement(
                        "insert into customer_orders (client_id, car_id, order_date) values (?, ?, ?)");
            }
            statement.setInt(1, customerOrder.getClientId());
            statement.setInt(2, customerOrder.getCarId());
            statement.setDate(3, Date.valueOf(customerOrder.getOrderDate()));
        }
        else {
            statement = connection.prepareStatement(
                    "insert into customer_orders (id, client_id, car_id, order_date) values (?, ?, ?, ?)");
            statement.setInt(1, customerOrder.getId());
            statement.setInt(2, customerOrder.getClientId());
            statement.setInt(3, customerOrder.getCarId());
            statement.setDate(4, Date.valueOf(customerOrder.getOrderDate()));
        }

        return statement;
    }

    @Override
    public Object getById(int id) throws SQLException {
        CustomerOrder customerOrder = new CustomerOrder();
        PreparedStatement statement = null;
        ResultSet queryRes = this.getEntityById("customer_orders", id, statement);

        if (queryRes.next()) {
            customerOrder.setId(queryRes.getInt("id"));
            customerOrder.setClientId(queryRes.getInt("client_id"));
            customerOrder.setCarId(queryRes.getInt("car_id"));
            customerOrder.setOrderDate(queryRes.getString("order_date"));
        }
        else {
            return null;
        }

        if (statement != null) { statement.close(); }
        if (queryRes != null) { queryRes.close(); }

        return customerOrder;
    }

    @Override
    public void delete(int id) throws SQLException {
        this.deleteEntityById("customer_orders", id);
    }
}
