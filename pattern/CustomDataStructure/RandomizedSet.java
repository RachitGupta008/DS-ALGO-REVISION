// At places where the ordering is not that much important you can use this trick to remove the element in O(1) time


import java.util.*;

class RandomizedSet {

    private Map<Integer, Integer> valueIndexMap;
    private List<Integer> values;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueIndexMap = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueIndexMap.containsKey(val)) {
            return false;
        }
        values.add(val);
        valueIndexMap.put(val, values.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueIndexMap.containsKey(val)) {
            return false;
        }
        int index = valueIndexMap.get(val);
        int lastValue = values.get(values.size() - 1);
        
        // Swap with the last element
        values.set(index, lastValue);
        valueIndexMap.put(lastValue, index);
        
        // Remove last element
        values.remove(values.size() - 1);
        valueIndexMap.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = rand.nextInt(values.size());
        return values.get(randomIndex);
    }
}
