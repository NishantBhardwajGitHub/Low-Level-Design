package Dao;

import LRUcache.Cache;
import policy.EvictionPolicy;

public class CacheDao {
    private static CacheDao cacheDao = null;
    private Cache cache = null;

    private CacheDao(){}

    public static CacheDao getInstance(){
        if(cacheDao==null){
            cacheDao = new CacheDao();
        }
        return cacheDao;
    }

    public Cache createCache(int size , EvictionPolicy evictionPolicy){
        cache = new Cache(size , evictionPolicy);
        return cache;
    }

    public Object get(Object obj) {
        Object result = cache.getCacheStore().get(obj);

        if(result==null){
            return null;
        }

        cache.getDataStore().remove(obj);
        cache.getDataStore().addFirst(obj);
        return result;
    }

    public boolean put(Object key , Object Value){
        try{

            if(cache.getSize()==cache.getDataStore().size()){
                Object Last = cache.getDataStore().removeLast();
                cache.getCacheStore().remove(Last);

            }

            cache.getDataStore().remove(key);
            cache.getDataStore().addFirst(key);
            cache.getCacheStore().put(key , Value);
            return true;
        }


        catch(Exception e){
            System.out.println("some error occured while adding element");

        }
        return false;
    }

    public boolean remove(Object obj){
        if(cache.getDataStore().size()==0) return true;

        try{
            cache.getDataStore().remove(obj);
            cache.getCacheStore().remove(obj);
            return true;
        }

        catch(Exception e){
            System.out.println("some error occured while adding element");
        }

        return false;
    }
    public boolean clear(){
        return cache.clearCache();
    }





}

