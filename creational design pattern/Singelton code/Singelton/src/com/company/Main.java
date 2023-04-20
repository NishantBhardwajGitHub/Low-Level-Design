package com.company;

public class Main {

    public static void main(String[] args) {

        //check if this is working or not
	    ///////Singleton s = new Singleton();

        Singleton singleton = Singleton.getInstance();
        singleton.sayHello();

        Singleton singleton2 = Singleton.getInstance();
        singleton2.sayHello();
        //What are some real life examples of Singleton Pattern ?
    }
}
