package com.Gleb.repositories;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.DBConnection;

import java.sql.*;

public class CustomerOrdersRepository implements Repository {

    private PreparedStatement createStatement(CustomerOrder customerOrder, boolean isUpdate) throws SQLException {
        PreparedStatement statement;
        if (isUpdate) {
            statement = DBConnection.getConnection().prepareStatement(
                    "update customer_orders set client_id = ?, car_id = ?, order_date = ? where id = ?");
            statement.setInt(4, customerOrder.getId());
        }
        else {
            statement = DBConnection.getConnection().prepareStatement(
                    "insert into customer_orders (client_id, car_id, order_date) values (?, ?, ?)");
        }
        statement.setInt(1, customerOrder.getClientId());
        statement.setInt(2, customerOrder.getCarId());
        statement.setDate(3, Date.valueOf(customerOrder.getOrderDate()));

        return statement;
    }

    @Override
    public Object getById(int id) throws Exception {
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
            throw new Exception();
        }

        if (statement != null) { statement.close(); }
        if (queryRes != null) { queryRes.close(); }

        return customerOrder;
    }

    @Override
    public void add(Object entity) throws SQLException {
        this.executeUpdateTable(this.createStatement((CustomerOrder) entity, false));
    }

    @Override
    public void update(Object entity) throws SQLException {
        this.executeUpdateTable(this.createStatement((CustomerOrder) entity, true));
    }

    @Override
    public void delete(int id) throws SQLException {
        this.deleteEntityById("customer_orders", id);
    }
}
