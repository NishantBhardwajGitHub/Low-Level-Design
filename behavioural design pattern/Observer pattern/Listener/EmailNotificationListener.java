package Listener;

import java.io.File;

public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String Email ){
        this.email=Email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to : " + email+ " someone has performed " + eventType + " with the following file " + file.getName() );
    }
}
