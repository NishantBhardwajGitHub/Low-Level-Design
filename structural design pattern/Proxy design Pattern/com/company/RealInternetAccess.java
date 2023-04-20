package com.company;

public class RealInternetAccess implements InternetAccess {

    private String employee;
    public RealInternetAccess(String emp){
        this.employee=emp;

    }
    @Override
    public void grantInternetAccess() {
        System.out.println("Internet Access Granted for employee " + this.employee);

    }
}
