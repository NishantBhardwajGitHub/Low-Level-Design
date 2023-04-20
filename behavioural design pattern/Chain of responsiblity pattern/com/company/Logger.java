package com.company;

public abstract class Logger {

    public static int consoleinfo = 1;
    public static int errorinfo = 2;
    public static int debuginfo = 3;

    protected  int level ;

    protected Logger nextlevellogger ;

    public void setNextlevelloggerLogger(Logger  nextlevellogger){
        this.nextlevellogger = nextlevellogger;
    }

    public void logMessage(int level , String msg){
        if(this.level<= level){
            displayLogInfo(msg);
        }

        if(nextlevellogger != null){
            nextlevellogger.logMessage(level, msg);

        }
    }

    public void displayLogInfo(String msg){}
}
