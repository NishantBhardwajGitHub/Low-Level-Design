import Listener.EventListener;

import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public Editor(){
        this.events= new EventManager("open" , "save");
    }

    public void openFile(String pathname){
        this.file = new File(pathname);
        events.notify("open" , file);
    }


    public void saveFile()throws Exception{

        if(this.file!=null){

            events.notify("save" , file);
        }
        else{
            throw new Exception("please open a file first");

        }
    }

}
