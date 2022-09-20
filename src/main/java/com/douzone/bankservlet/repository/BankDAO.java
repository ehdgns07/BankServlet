package com.douzone.bankservlet.repository;

import com.douzone.bankservlet.domain.Bank;

import java.sql.Connection;
import java.sql.SQLException;

import static com.douzone.bankservlet.utils.DBUtils.getConnection;

public class BankDAO {
    private static BankDAO instance = new BankDAO();

    private BankDAO(){}

    public static BankDAO getInstance() {
        return instance;
    }




}
