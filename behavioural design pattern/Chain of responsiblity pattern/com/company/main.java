package com.company;

public class main {
    private static  Logger dochaining(){
        Logger consolelog = new ConsoleLog(Logger.consoleinfo);
        Logger errorlog = new ErrorLog(Logger.errorinfo);
        Logger debuglog = new DebugLogger(Logger.debuginfo);

        consolelog.setNextlevelloggerLogger(errorlog);
        errorlog.setNextlevelloggerLogger(debuglog);

        return consolelog;

    }

    public static void main(String[] args) {

        Logger Client = dochaining();
         Client.logMessage(Logger.consoleinfo  , ": Enter the sequence of values");
         Client.logMessage(Logger.errorinfo  , ": an error occurred ");
         Client.logMessage(Logger.debuginfo , ": this was the error now debugging is completed");

    }
}
