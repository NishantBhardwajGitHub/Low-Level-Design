package com.company;

public class ProxyInternetAccess implements InternetAccess {

    private RealInternetAccess realInternetAccess;
    String employee;

    public ProxyInternetAccess(String employee){
        this.employee= employee;
    }

    public int getrank(String employee){
        return 6;
    }

    @Override
    public void grantInternetAccess() {

        if(getrank(this.employee) > 4){
            realInternetAccess = new RealInternetAccess(employee);
            realInternetAccess.grantInternetAccess();

        }
        else{
            System.out.println("Access denied for employee " +employee);
        }

    }
}
