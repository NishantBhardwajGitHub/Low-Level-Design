package com.company;

public class Singleton {
    //data member
    static Singleton instance = null;

    //constructor private
    private Singleton() {

    }

    static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void sayHello() {
        System.out.println("Hi, I m a Singleton Class");
        System.out.println(instance);
    }
}
