package com.company;

public class IPhone implements MobileShop {

    @Override
    public void getModel() {
        System.out.println("i phone 14 pro max");
    }

    @Override
    public void getprice() {
        System.out.println("Rupees : 1,40,000");
    }
}
