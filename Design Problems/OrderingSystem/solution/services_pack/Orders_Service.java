package services_pack;

import Data_pack.Dao;
import models_pack.Orders;

import java.util.List;

public class Orders_Service {
    private static Orders_Service  instance = null;

    private Orders_Service(){}

    public static Orders_Service getInstance(){
        if(instance==null){
            instance = new Orders_Service();

        }
        return instance;
    }
    Dao userDao = Dao.getInstance();

    public Orders placeOrder(String name , int quantity){
        if(quantity <= 0){
            System.out.println("invalid value for marked fields");
        }
        return userDao.placeOrder(name , quantity);
    }
    public List<Orders> listOrders(){
        return userDao.listOrders();
    }





}
