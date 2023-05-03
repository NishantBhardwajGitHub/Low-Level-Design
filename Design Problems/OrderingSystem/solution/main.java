import constants_pack.Gender;
import models_pack.Orders;
import models_pack.Restaurant;
import models_pack.Reviews;
import models_pack.User;
import services_pack.Orders_Service;
import services_pack.Restaurant_Service;
import services_pack.User_Service;

import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("excecution started");
        User_Service user = User_Service.getInstance();
        Restaurant_Service restaurant = Restaurant_Service.getInstance();
        Orders_Service order = Orders_Service.getInstance();


        User nishant = user.registerUser("nishant" , 9910979258L , 122001L , Gender.Male);
        User deepanshu = user.registerUser("deepanshu" , 9999999999L , 122006L , Gender.Male);
        User Ayush = user.registerUser("Ayush" , 8899106223L , 140413L , Gender.Male);
        User taru = user.registerUser("Tarushi" , 9927379203L , 122001L , Gender.Female);

        User login = user.loginUser(nishant.getContact());

        Restaurant Leela = restaurant.registerrestaurant("Leela" , "butter chicken" , 1000 , "122001" , 10);
        Restaurant Havmor = restaurant.registerrestaurant("Havmor" , "chickn tikka" , 500 ,"140413,122001" , 5 );

        Leela = restaurant.updateQuantity("Leela" , 5);
        login= user.loginUser(deepanshu.getContact());

        Restaurant kareems = restaurant.registerrestaurant("kareems" , "chicken seekh" , 400 , "122001,122006" , 5);
        login = user.loginUser(taru.getContact());

        Restaurant Baba = restaurant.registerrestaurant("Baba" , "pizza" , 300 , "140413" , 5);
        restaurant.showRestaurant("rating");
        Orders orderss = Orders_Service.getInstance().placeOrder("Havmor" , 4);
        Reviews reviews = restaurant.rateRestaurant("Havmor" , 4 , "good");

        List<Orders> ordersList = order.listOrders();
        restaurant.showRestaurant("Rating");
        System.out.println("execution ended");






    }
}
