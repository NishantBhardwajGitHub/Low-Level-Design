import Listener.EmailNotificationListener;
import Listener.LogOpenListener;

public class main {
    public static void main(String[] args) {

        Editor editor = new Editor();

        editor.events.subscribe("open" , new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save" , new EmailNotificationListener("nishantbhardwaj2367@gmail.com"));


        try {
            editor.openFile("test.txt");
            editor.saveFile();
        }
        catch ( Exception e){
            e.printStackTrace();
        }

    }
}
