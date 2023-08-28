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

        if (queryRes != null) { queryRes.close(); }
        if (statement != null) { statement.close(); }

        return customerOrder;
    }

    public void addCustomerOrder(CustomerOrder customerOrder) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("insert into customer_orders (client_id, car_id, order_date) " +
                    "values (" + customerOrder.getClientId() + ", " + customerOrder.getCarId()
                    + ", '" + customerOrder.getOrderDate() + "')");

        if (statement != null) { statement.close(); }
    }

    public void updateCustomerOrder(CustomerOrder customerOrder) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("update customer_orders set client_id = " + customerOrder.getClientId() +
                    ", car_id = " + customerOrder.getCarId() + ", order_date = '" + customerOrder.getOrderDate()
                    + "' where id = " + customerOrder.getId());

        if (statement != null) { statement.close(); }
    }

    public void deleteCustomerOrder(int id) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("delete from customer_orders where id = " + id);

        if (statement != null) { statement.close(); }
    }
}
