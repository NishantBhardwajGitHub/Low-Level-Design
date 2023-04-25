package Listener;

import java.io.File;

public class LogOpenListener implements EventListener{

    private File log;

    public LogOpenListener(String filename){
        this.log = new File(filename);
    }


    @Override
    public void update(String eventType, File file) {

        System.out.println("save to log :" + log + " someone has performed " + eventType + " operation with the following File : " + file.getName());

    }
}
