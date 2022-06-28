class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        
        
        for(String word: wordDict){
            dict.add(word);
        }
       
        List<List<String>> dp = new ArrayList<>();
        
      
        
        
        for(int i=0;i<s.length();i++){
            dp.add(new ArrayList<>());
            for(int j=0;j<=i;j++){
                //System.out.println(s.substring(j,i+1));
                
                //System.out.println(dict.contains(s.substring(j,i+1)));
                
                
                boolean ans = ( dict.contains(s.substring(j,i+1)) && (j==0?true:dp.get(j-1).size()>0));
                
                if(ans){
                    if(j==0){
                        List<String> l = dp.get(i);
                        l.add(s.substring(j,i+1));
                        
                    }else{
                         List<String> l = dp.get(i);
                        List<String> l2 = dp.get(j-1);
                        
                        for(String word : l2){
                            
                            l.add(word+" "+s.substring(j,i+1));
                        }
                        
                    }
                    
                }
                
            }
//System.out.println(dp[i]);
            
        }
        return dp.get(s.length()-1);
    }
}
