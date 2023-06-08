class FreqStack {

    Map<Integer, Stack<Integer>> map;
    Map<Integer, Integer> map1;
    int mx = 0;

    public FreqStack() {
        map = new HashMap<>();
        map1= new HashMap<>();
    }
    
    public void push(int val) {

        map1.put(val, map1.getOrDefault(val,0)+1);
        int freq = map1.get(val);

        Stack<Integer> stk = map.getOrDefault(freq, new Stack<>());
        stk.push(val);
        map.put(freq, stk);

        mx = Math.max(freq, mx);
        
    }
    
    public int pop() {

        int elem = map.get(mx).pop();

        

        if(map1.get(elem) == 1){
            map1.remove(elem);
        }else{
            map1.put(elem, map1.get(elem)-1);
        }

        if(map.get(mx).isEmpty()){
            map.remove(mx);
            mx = mx-1;

        }
        return elem;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
