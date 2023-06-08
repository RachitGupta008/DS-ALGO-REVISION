class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        Map<String, List<String>> ans = new HashMap<>();
        
        List<List<String>> sol = new ArrayList<>();
        for(String s : strs){
            
            char[] c = s.toCharArray();
           // This can also be done without sort by building a key from a list of chars[26] where each filed contains frequency
            Arrays.sort(c);
            
            String m = new String(c);
            
            List<String> t = ans.getOrDefault(m, new ArrayList<>());
            t.add(s);
            
            ans.put(m, t);
            
            
        }
        
        
        
        
        return new ArrayList<List<String>>(ans.values());
    }
}
