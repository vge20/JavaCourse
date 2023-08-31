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

    public CustomerOrder getCustomerOrderById(int id) throws Exception {
        CustomerOrder customerOrder = new CustomerOrder();
        ResultSet queryRes = this.getEntityById("customer_orders", id);

        if (queryRes.next()) {
            customerOrder.setId(queryRes.getInt("id"));
            customerOrder.setClientId(queryRes.getInt("client_id"));
            customerOrder.setCarId(queryRes.getInt("car_id"));
            customerOrder.setOrderDate(queryRes.getString("order_date"));
        }
        else {
            throw new Exception();
        }

        if (queryRes != null) { queryRes.close(); }

        return customerOrder;
    }

    public void addCustomerOrder(CustomerOrder customerOrder) throws SQLException {
        this.executeUpdateTable(this.createStatement(customerOrder, false));
    }

    public void updateCustomerOrder(CustomerOrder customerOrder) throws SQLException {
        this.executeUpdateTable(this.createStatement(customerOrder, true));
    }

    public void deleteCustomerOrder(int id) throws SQLException {
        this.deleteEntityById("customer_orders", id);
    }
}
