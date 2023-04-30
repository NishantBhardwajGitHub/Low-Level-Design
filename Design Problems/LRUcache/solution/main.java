import CacheService.CacheService;
import LRUcache.Cache;
import policy.EvictionPolicy;

public class main {
    public static void main(String[] args) {
        CacheService cacheservice = CacheService.getInstance();
        Cache cache = cacheservice.init(10 , EvictionPolicy.LRU);
        cacheservice.put("nishant" , "bhardwaj");
        System.out.println(cacheservice.get("nishant"));




    }
}
