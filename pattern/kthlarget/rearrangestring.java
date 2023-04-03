// We store the previous in variable and then build the string.

class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
		// order all characters present in string in desending order of their count
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
            return (map.get(b)).compareTo(map.get(a));
        });
        
        int len = s.length();
        char ch;
        
        for(int i=0;i<len;i++){
            ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(entry.getKey());
        }
        
        StringBuffer sb = new StringBuffer("");
		
		//run till all characters are used to make new string
        while(!pq.isEmpty()){
            char a = pq.poll();
            if(pq.isEmpty()){
				// if more than one characters of same type is left then reorganizing is not possible
                if(map.get(a)>1)
                    return "";
                else
                    sb.append(a+"");
                break;
            }
            char b = pq.poll();
            
			//1.use the characters a and b and descrease their count in map
			//2.if count is still more than 0 after this then we need to add back to the queue.
			
                sb.append(a+"");
                map.put(a,map.get(a)-1);
                sb.append(b+"");
                map.put(b,map.get(b)-1);
            
            if(map.get(a)!=0)
                pq.add(a);
            
            if(map.get(b)!=0)
                pq.add(b);
        }
        
        return sb.toString();
    }
}
