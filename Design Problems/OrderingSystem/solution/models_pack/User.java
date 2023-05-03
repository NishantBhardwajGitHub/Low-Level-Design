package models_pack;

import constants_pack.Gender;

import java.util.ArrayList;
import java.util.List;

public class User {


        private int id ;
        private String name;
        private Gender gender;
        private Long contact;
        private Long pincode;
        private List<Restaurant> restaurantlist = new ArrayList<>();
        private List<Orders> ordersList = new ArrayList<>();

        public User(int id , String name , Gender gender , Long contact , Long pincode ){
            this.id=id;
            this.name=name;
            this.gender=gender;
            this.contact=contact;
            this.pincode=pincode;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getContact() {
            return contact;
        }

        public void setContact(long contact) {
            this.contact = contact;
        }

        public long getPincode() {
            return pincode;
        }

        public void setPincode(long pincode) {
            this.pincode = pincode;
        }

        public List<Restaurant> getRestaurantlist() {
            return restaurantlist;
        }

        public void setRestaurantlist(List<Restaurant> restaurantlist) {
            this.restaurantlist = restaurantlist;
        }

        public List<Orders> getOrdersList() {
            return ordersList;
        }

        public void setOrdersList(List<Orders> ordersList) {
            this.ordersList = ordersList;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }
}
