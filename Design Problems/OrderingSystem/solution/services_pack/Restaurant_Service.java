package services_pack;

import Data_pack.Dao;
import models_pack.Restaurant;
import models_pack.Reviews;

import java.util.List;

public class Restaurant_Service {
    private static Restaurant_Service instance = null;

    private Restaurant_Service(){}

    public static Restaurant_Service getInstance(){
        if(instance==null){
            instance = new Restaurant_Service();

        }
        return instance;
    }
    Dao userdao = Dao.getInstance();

    public Restaurant registerrestaurant(String name , String item , int price , String pincodes , int quantity){
        if(price <= 0 || quantity<=0){
            System.out.println("invalid mandatory fields");
            return null;
        }
        if(name.isEmpty()){
            System.out.println("name cannot be empty");
            return null;
        }
        return userdao.registerRestaurant(name , item , price , pincodes , quantity);
    }

    public Reviews rateRestaurant(String name , Integer rating  , String comments){
        if(rating==null || rating <= 0 || rating > 5){
            System.out.println("invalid mandatory fields");
            return null;

        }
        return userdao.rateRestaurant(name , rating , comments);
    }

    public Restaurant updateQuantity(String name , int quanity){

        if(quanity <= 0){
            System.out.println("invalid value for marked fields");
            return null;
        }
        return  userdao.updateQuantity(name , quanity);

    }
    public List<Restaurant> showRestaurant(String sortBy){
        return userdao.showRestaurant(sortBy);
    }






}
