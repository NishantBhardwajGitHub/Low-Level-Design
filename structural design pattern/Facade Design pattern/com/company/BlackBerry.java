package com.company;

public class BlackBerry implements MobileShop {

    @Override
    public void getModel() {
        System.out.println("BlackBerry Z10");
    }

    @Override
    public void getprice() {
        System.out.println("Rupees : 60,000");
    }
}
