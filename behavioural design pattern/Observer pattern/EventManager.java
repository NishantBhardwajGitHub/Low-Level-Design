import Listener.EventListener;

import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    Map<String , List<EventListener>> listeners = new HashMap<String, List<EventListener>>();

    public EventManager(String... operations){
        for(String operation : operations){
            this.listeners.put(operation , new ArrayList<>());
        }
    }
    public void subscribe(String eventtype , EventListener listener){
        List<EventListener> users = listeners.get(eventtype);
        users.add(listener);


    }

    public void unsubscribe(String eventtype , EventListener listener){
        List<EventListener> users = listeners.get(eventtype);
        users.remove(listener);
    }

    public void notify(String eventtype , File file){
        List <EventListener> users = listeners.get(eventtype);

        for(EventListener listener : users){
            listener.update(eventtype , file);
        }

    }

}
