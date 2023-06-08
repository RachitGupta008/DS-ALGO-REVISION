 public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int idx = -1;
        
        for(int i=0;i<s.length();i++){
            Character key = s.charAt(i);
            if(map.containsKey(key)){
                
                map.put(key, -1);
            }else{
                map.put(key, i);
            }
        }
        
        for(int i=0;i<s.length();i++){
             Character key = s.charAt(i);
            if(map.get(key)!=-1){
                return map.get(key);
            }
        }
        
        return -1;
    }
