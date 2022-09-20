package com.douzone.bankservlet.service;


import com.douzone.bankservlet.domain.Customer;
import com.douzone.bankservlet.repository.CustomerDAO;

import java.sql.SQLException;
import java.util.List;

public class LoginService {
    private static LoginService instance = new LoginService();
    CustomerDAO customerDAO = CustomerDAO.getInstance();

    private LoginService(){}

    public static LoginService getInstance() {
        return instance;
    }

    public Customer loginCheck(String name, String pwd) throws SQLException {
        List<Customer> customers = customerDAO.findAll();

        return customers.stream().filter((customer)-> customer.getCustomerId().equals(name)).filter(customer -> customer.getPwd().equals(pwd)).findFirst().orElse(null);
    }
}
