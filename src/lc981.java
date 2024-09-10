import java.util.*;

public class lc981 {
    TimeMap obj = new TimeMap();

}
class TimeMap {
    Map<String, TreeMap<Integer,String>> outermap;
    // using Map while declaring makes is more flexible whereas writing hashmap restricts it to Hashmap onlu
    public TimeMap() {
        outermap=new HashMap<>();//creating the hashmap
    }

    public void set(String key, String value, int timestamp) {
        //if key is present then get the innerMap at that key else create a new map
        TreeMap<Integer,String> innerMap=outermap.getOrDefault(key, new TreeMap<>());

        innerMap.put(timestamp,value);
        outermap.put(key, innerMap);

    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> innerMap=outermap.get(key);
        if(innerMap==null || innerMap.size()==0) return "";
        Integer lastkey=innerMap.floorKey(timestamp);
        if(lastkey==null) return "";
        return innerMap.get(lastkey);
    }
}