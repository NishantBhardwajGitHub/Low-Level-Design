package LRUcache;

import policy.EvictionPolicy;

import java.util.HashMap;
import java.util.LinkedList;

public class Cache {
    private int size;
    private EvictionPolicy evictionpolicy;
    private LinkedList<Object> dataStore;
    private HashMap<Object , Object> cacheStore;

    public Cache(int size , EvictionPolicy evictionpolicy){
        this.size=size;
        this.evictionpolicy=evictionpolicy;
        dataStore = new LinkedList<>();
        cacheStore= new HashMap<>();
    }

    public boolean clearCache(){
        try{
            dataStore = new LinkedList<>();
            cacheStore= new HashMap<>();
            return true;
        }
        catch (Exception e){
            System.out.println("Some error happened while clearing the cache");
        }
        return false;
    }

    public  int getSize(){
        return size;
    }

    public EvictionPolicy getEvictionpolicy(){
        return evictionpolicy;
    }

    public LinkedList<Object> getDataStore(){
        return dataStore;
    }
    public HashMap<Object, Object> getCacheStore(){
        return cacheStore;
    }


}
