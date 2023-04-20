package com.company;

public class Samsung implements  MobileShop{

    @Override
    public void getModel() {
        System.out.println("Samsung s22 Ultra");
    }

    @Override
    public void getprice() {
        System.out.println("Rupees : 1,00,000");
    }
}
