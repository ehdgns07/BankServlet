package com.douzone.bankservlet.repository;

import com.douzone.bankservlet.domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.douzone.bankservlet.utils.DBUtils.getConnection;

public class CustomerDAO {
    private static CustomerDAO instance = new CustomerDAO();

    private CustomerDAO() {
    }

    public static CustomerDAO getInstance() {
        return instance;
    }

    public List<Customer> findAll() throws SQLException {
        Connection con = getConnection();
        PreparedStatement psmt = con.prepareStatement("select * from customer");
        ResultSet rs = psmt.executeQuery();
        List<Customer> customers = new ArrayList<>();

        while(rs.next()){
            customers.add(new Customer(rs.getString("customerId"), rs.getString("name"), rs.getString("password"),rs.getLong("cash")));
        }
        return customers;
    }
}
