package com.Gleb.repositories;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerOrdersRepository {

    public CustomerOrder getCustomerOrderById(int id) throws Exception {
        CustomerOrder customerOrder = new CustomerOrder();
        Statement statement = null;
        ResultSet queryRes = null;

        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            queryRes = statement.executeQuery("select * from customer_orders c where c.id = " + id);

            if (queryRes.next()) {
                customerOrder.setId(queryRes.getInt("id"));
                customerOrder.setClientId(queryRes.getInt("client_id"));
                customerOrder.setCarId(queryRes.getInt("car_id"));
                customerOrder.setOrderDate(queryRes.getString("order_date"));
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

        return customerOrder;
    }

    public void addCustomerOrder(CustomerOrder customerOrder) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("insert into customer_orders (client_id, car_id, order_date) " +
                    "values (" + customerOrder.getClientId() + ", " + customerOrder.getCarId()
                    + ", '" + customerOrder.getOrderDate() + "')");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void updateCustomerOrder(CustomerOrder customerOrder) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("update customer_orders set client_id = " + customerOrder.getClientId() +
                    ", car_id = " + customerOrder.getCarId() + ", order_date = '" + customerOrder.getOrderDate()
                    + "' where id = " + customerOrder.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void deleteClient(int id) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("delete from customer_orders where id = " + id);

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
