package CacheService;

import Dao.CacheDao;
import LRUcache.Cache;
import policy.EvictionPolicy;

public class CacheService {
    public static CacheService instance = null;
    private CacheDao cachedao = CacheDao.getInstance();

    private CacheService(){}

    public static CacheService getInstance() {
        if(instance == null){
            instance = new CacheService();
        }
        return instance;
    }

    public Cache init(int size , EvictionPolicy evictionPolicy){

        return cachedao.createCache(size , evictionPolicy);
    }

    public Object get(Object obj){
        return cachedao.get(obj);

    }
    public boolean put(Object key , Object value){
        return cachedao.put(key , value);
    }
    public boolean remove(Object obj){
        return cachedao.remove(obj);
    }
    public boolean clear(){
        return cachedao.clear();
    }





}
