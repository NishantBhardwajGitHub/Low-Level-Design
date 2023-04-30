package com.company;

import java.security.spec.RSAOtherPrimeInfo;

public class ErrorLog  extends Logger{

    public ErrorLog(int level){
        this.level=level;
    }

    @Override
    public void displayLogInfo(String msg) {
        System.out.println("Error Logger Info " + msg);
    }
}
