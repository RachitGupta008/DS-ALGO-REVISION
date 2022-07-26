class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> t1 = new HashMap<>();
        int mcnt = 0;
        for(int i=0;i<t.length();i++){
            
            t1.put(t.charAt(i), t1.getOrDefault(t.charAt(i), 0)+1);
            mcnt++;
        }
        
        HashMap<Character, Integer> s1 = new HashMap<>();
        
        String ans = "";
        
        int scnt = 0;
        int i = 0;
        int j = 0;
        while(scnt<mcnt && i<s.length()){
            Character ch = s.charAt(i);
            s1.put(s.charAt(i), s1.getOrDefault(s.charAt(i), 0)+1);
            
            if(s1.get(ch) <= t1.getOrDefault(ch, 0)){
                scnt++;
            }
            i++;
            
            
        }
        
        if(scnt == mcnt)
        ans = s.substring(0, i);
        
        while(j<s.length()){
            Character ch = s.charAt(j);
            s1.put(ch, s1.getOrDefault(ch, 1)-1);
            if(s1.get(ch) < t1.getOrDefault(ch, -1)){
                scnt--;
            }
            j++;
            while(i<s.length() && scnt<mcnt){
            Character ch1 = s.charAt(i);
            s1.put(s.charAt(i), s1.getOrDefault(s.charAt(i), 0)+1);
            
            if(s1.get(ch1) <= t1.getOrDefault(ch1, 0)){
                scnt++;
            }
            i++;
            
            
        }
        
        if(scnt == mcnt && s.substring(j, i).length()<ans.length()){
            ans = s.substring(j, i);
        }
            
            
        }
        
        //System.out.println(ans);
        
        return ans;
        
    }
}
