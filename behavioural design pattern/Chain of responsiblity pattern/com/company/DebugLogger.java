package com.company;

public class DebugLogger extends Logger{

    public DebugLogger(int level){
        this.level = level;
    }


    @Override
    public void displayLogInfo(String msg) {
        System.out.println("Debug Logger Info " + msg);
    }
}
