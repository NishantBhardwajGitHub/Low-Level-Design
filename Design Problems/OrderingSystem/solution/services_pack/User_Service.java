package services_pack;

import Data_pack.Dao;
import constants_pack.Gender;
import models_pack.User;

public class User_Service {
    private static User_Service instance = null;

    private User_Service(){}

    public static User_Service getInstance(){
        if(instance==null){
            instance=new User_Service();

        }
        return instance;
    }

    private Dao userdao  = Dao.getInstance();

    public User registerUser(String name , Long contact , Long pincode , Gender gender){
        if(contact==null || contact < 0 || pincode == null || pincode <= 0 || name.isEmpty()){
            return null;
        }
        return userdao.registerUser(name , contact , pincode , gender);

    }

    public User loginUser(Long id){
        return userdao.loginUser(id);
    }





}

