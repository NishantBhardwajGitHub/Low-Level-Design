package com.company;

public class ShopKeeper {
    private  IPhone iPhone;
    private Samsung samsung;
    private BlackBerry blackBerry;

    public ShopKeeper(){
        iPhone = new IPhone();
        samsung = new Samsung();
        blackBerry = new BlackBerry();
    }

    public void iPhoneSale(){

        iPhone.getModel();
        iPhone.getprice();

    }

    public void samsungSale(){
        samsung.getModel();
        samsung.getprice();

    }

    public void blackberrySale(){
        blackBerry.getModel();
        blackBerry.getprice();

    }

}
