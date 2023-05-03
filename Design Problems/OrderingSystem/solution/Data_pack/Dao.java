package Data_pack;

import constants_pack.Gender;
import models_pack.Orders;
import models_pack.Restaurant;
import models_pack.Reviews;
import models_pack.User;
import utils_pack.Id_Generator;

import java.util.*;

public class Dao {
    private static Dao instance = null;
    private User loggedinUser = null;

    private Dao(){}

    public static Dao getInstance(){
        if(instance==null){
            instance=new Dao();
        }
        return instance;
    }

    private HashMap <Integer , User> usermapping = new HashMap<>();
    private HashMap<Long , Integer> contactmapping = new HashMap<>();
    private HashMap<String , Restaurant> restaurantmapping = new HashMap<>();

    public User registerUser(String Username , Long contact , Long pincode , Gender gender){

        if(contactmapping.containsKey(contact)){
            User user = usermapping.get(contactmapping.get(contact));
            System.out.println("user already registered with name : " + Username + ", contact number : " + contact);
            return user;
        }

        User user= new User(Id_Generator.generateId() , Username , gender , contact , pincode);
        usermapping.put(user.getId(),user);
        contactmapping.put(contact,user.getId());

        System.out.println("successfully created user with id : " + user.getId() + " and name : " + Username);
        return user;
    }

    public User loginUser(Long contact){
        if(!contactmapping.containsKey(contact)){
            System.out.println("user doesn't exists , please resister user first");
            return  null;
        }
        User user = usermapping.get(contactmapping.get(contact));
        loggedinUser=user;
        System.out.println("logged in successfully");
        return user;
    }

    public Restaurant registerRestaurant(String restaurantname , String item , int price ,String pincodes , int quantity){
        if(loggedinUser==null){
            System.out.println("No user is logged in , please log in a user first");
            return null;
        }

        else if(restaurantmapping.containsKey(restaurantname)){
            System.out.println("Restaurant is already registered with the given name : " + restaurantname );
            return null;
        }
        List<String > pincodeslist = Arrays.asList(pincodes.split(","));
        List<Long> pins = new ArrayList<>();

        if(!pincodes.isEmpty()){
            for(String s : pincodeslist){
                if(!s.chars().allMatch(Character::isDigit)){
                    System.out.println("invalid pincode provided");
                    return null;
                }
                pins.add(Long.parseLong(s));
            }

        }
        Restaurant restaurant =  new Restaurant();
        restaurant.setId(Id_Generator.generateId());
        restaurant.setName(restaurantname);
        restaurant.setItem(item);
        restaurant.setQuantity(quantity);
        restaurant.setCost(price);
        restaurant.setServiceablepincodes(pins);
        restaurant.setCreatedby(loggedinUser.getId());

        restaurantmapping.put(restaurantname , restaurant);

        loggedinUser.getRestaurantlist().add(restaurant);

        System.out.println("successfully registered a restaurant with id : " + restaurant.getId() + "\n");
        return restaurant;


    }

    public Reviews rateRestaurant(String restaurantname , Integer rating , String comment){
        Restaurant restaurant = restaurantmapping.get(restaurantname);

        if(restaurant==null){
            System.out.println("No restaurant found with the given name : " + restaurantname +"\n");
            return null;
        }
        Reviews reviews = new Reviews();
        reviews.setId(Id_Generator.generateId());
        reviews.setScore(rating);
        reviews.setComment(comment);

        if(restaurant.getReviews()==null || restaurant.getReviews().size()==0){
            restaurant.setRating(Float.valueOf(rating));
        }
        else{
            Float currentscore = (restaurant.getRating() * restaurant.getReviews().size() + rating) / (restaurant.getReviews().size() + 1);
            restaurant.setRating(currentscore);
        }
        restaurant.getReviews().add(reviews);
        return reviews;
    }

    public Restaurant updateQuantity(String restaurantname , int quanity){
        Restaurant restaurant = restaurantmapping.get(restaurantname);

        if(restaurant==null){
            System.out.println("no restaurant found with the given name : " + restaurantname +"\n");
            return null;
        }
        restaurant.setQuantity(restaurant.getQuantity()+quanity);
        return restaurant;

    }

    public List<Restaurant> showRestaurant(String sortBy){
        List <Restaurant> userrestaurants = loggedinUser.getRestaurantlist();
        List<Restaurant> restaurants = new ArrayList<>();

        for(Restaurant restaurant : restaurants){
            if(restaurant.getServiceablepincodes().contains(loggedinUser.getPincode()) && restaurant.getQuantity() >0){
                restaurants.add(restaurant);
            }
        }

        if(sortBy.equalsIgnoreCase("rating")){
            Collections.sort(restaurants , new SortByRating());
            for(Restaurant restaurant: restaurants){
                System.out.println("Restaurant id :"+restaurant.getId()+ ": name-> "+
                        restaurant.getName()+": price-> "+restaurant.getCost()+": rating -> "+restaurant.getRating());
            }
            return restaurants;
        }

        Collections.sort(restaurants,new SortByPrice());
        for(Restaurant restaurant: restaurants){
            System.out.println("Restaurant id :"+restaurant.getId()+ ": name-> "+
                    restaurant.getName()+": price-> "+restaurant.getCost()+": rating -> "+restaurant.getRating());
        }
        return restaurants;

    }


    public Orders placeOrder(String name, Integer quantity) {
        Restaurant restaurant = restaurantmapping.get(name);
        if (restaurant == null) {
            System.out.println("No restaurant found with given name " + name);
            return null;
        }

        if (restaurant.getQuantity()==0) {
            System.out.println("restaurant is out of stock, please try later");
            return null;
        }

        if(restaurant.getQuantity()<quantity){
            System.out.println("Restaurant has only" + restaurant.getQuantity()+" Items, please check your cart");
            return null;
        }

        Orders order =new Orders();
        order.setId(Id_Generator.generateId());
        order.setItem(restaurant.getItem());
        order.setQuantity(quantity);
        order.setId(loggedinUser.getId());
        order.setTimestamp(System.currentTimeMillis());
        order.setCost((quantity*restaurant.getCost()));
        //update quantity
        restaurant.setQuantity(restaurant.getQuantity()-quantity);
        //add to user order history
        loggedinUser.getOrdersList().add(order);
        return order;
    }

    public List<Orders> listOrders() {
        for(Orders order: loggedinUser.getOrdersList()){
            System.out.println("Order id :"+order.getId()+" item:"+
                    order.getItem()+" quantity:"+order.getQuantity()+" cost:"+order.getCost());
        }
        return loggedinUser.getOrdersList();
    }

}

class SortByRating implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant o1, Restaurant o2) {

        if(o1.getRating()>o2.getRating()) {
            return 1;
        }
        else if(o1.getRating()==o2.getRating()){
            return 0;
        }
        else {
            return -1;
        }
    }
}
class SortByPrice implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        return o1.getCost() - o2.getCost();
    }
}
