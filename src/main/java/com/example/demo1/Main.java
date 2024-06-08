package com.example.demo1;

public class Main{
    public static void main(String[] args) {
        Login login = new Login();

        LoginPage loginPage = new LoginPage(login.getLoginInfo());
    }
}