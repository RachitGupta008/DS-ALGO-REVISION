// The logic reside in the backtracking tree, can use prev and new logic alsoe both will work.
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        
        List<List<Integer>> ans= new ArrayList<>();
        ans.add(new ArrayList<>());
        Set<List<Integer>> fans= new HashSet<>();
        f(nums, 0, ans, fans);
        
        List<List<Integer>> sans= new ArrayList<>();
        
        
        for(List<Integer> li :  fans){
                sans.add(li);
        }
        
        return sans;
    }
    
   
    
    void f(int[] nums, int i, List<List<Integer>> ans, Set<List<Integer>> fans){
        
        if(i==nums.length){
           fans.addAll(ans);
           return;
        }
        List<List<Integer>> nans = new ArrayList<>();
        
        for(List<Integer> li : ans){
            
            List<Integer> temp = new ArrayList<>();
             List<Integer> temp1 = new ArrayList<>();
            
            temp.addAll(li);
            temp1.addAll(li);
            
            if(temp.size()==0 || (temp.size()>0 && temp.get(temp.size()-1)!=nums[i])){
                //temp.add(nums[i]);
                nans.add(temp);
                
            }
            temp1.add(nums[i]);
            nans.add(temp1);
            
        }
        
        
        f(nums, i+1, nans, fans);
        
       
        
    }
    
}
