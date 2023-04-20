package com.company;

public class ConsoleLog extends Logger {

    public ConsoleLog(int levels){
        this.level=levels;
    }
    @Override
    public void displayLogInfo(String msg) {
        System.out.println("Console Logger Info " + msg);
    }
}
