class Solution {
    public int lengthOfLongestSubstring(String st) {
        int s = 0;
        int e = 0;
        int mk = 0;
        Set<Character> set = new HashSet<>();
        while(e<st.length()){
            
            while(e<st.length() && !set.contains(st.charAt(e))){
                set.add(st.charAt(e));
                e++;
            }
            mk = Math.max(e-s, mk);
            
            set.remove(st.charAt(s));
            s++;
            
            
        }
       return mk; 
    }
}
