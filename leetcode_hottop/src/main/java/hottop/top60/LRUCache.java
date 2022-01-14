package hottop.top60;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @FileName: No146
 * @Description: LRU
 * @Author: zyk
 * @createTime: 2021/12/20 9:31
 * @version: 1.0
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

   public int get(int key){
        return super.getOrDefault(key,-1);
   }

   public void put(int key,int value){
        super.put(key,value);
   }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}
