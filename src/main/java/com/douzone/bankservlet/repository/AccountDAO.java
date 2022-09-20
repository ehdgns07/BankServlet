package com.douzone.bankservlet.repository;

public class AccountDAO {
    private static AccountDAO instance = new AccountDAO();

    private AccountDAO(){}

    public static AccountDAO getInstance() {
        return instance;
    }
}
