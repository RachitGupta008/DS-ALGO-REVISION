class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        TreeMap<Integer, String> temp = map.getOrDefault(key, new TreeMap<>());

        temp.put(timestamp, value);
        map.put(key, temp);


    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            Map.Entry<Integer, String> entry= map.get(key).floorEntry(timestamp);
            return entry==null?"":entry.getValue();
        }else{
            return "";
        }
    }
}

// This is a binary search based method
import java.util.*;

class TimeMap {

    class Pair implements Comparator<Pair> {
        int ts;
        String s;
        Pair(int ts, String s){
            this.ts = ts;
            this.s = s;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.ts - o2.ts;
        }
    }

    Map<String, List<Pair>> map;


    public TimeMap() {
        map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {

        List<Pair> temp;
        if(!map.containsKey(key)){
            temp = new ArrayList<>();
        }else{
            temp = map.get(key);
        }
        temp.add(new Pair(timestamp, value));
        map.put(key, temp);


    }

    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)){
            return "";
        }

       int idx =  Collections.binarySearch(map.get(key), new Pair(timestamp,""), Comparator.comparingInt(a -> a.ts));
       
    //System.out.println(idx);
        if(idx <0){
            idx = -(idx+1)-1;
        }
        //System.out.println(idx);
        if(idx<0){
            return "";
        }
        
        return map.get(key).get(idx).s;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
