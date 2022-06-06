class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }
            return o2[0]-o1[0];
        });
        int[] arr = new int[envelopes.length];
       
        return solution(envelopes);
    }
    
    //LIS using Binary Search optimized for O(N LOGN)
    public int solution(int[][] arr){
        
        List<Integer>dp = new ArrayList<>();
        int len = 0;
        for (int i = arr.length-1; i >=0; i--) {
        int idx = Collections.binarySearch(dp,arr[i][1]);
            
        if(idx<0){
            idx = Math.abs(idx)-1;
        }
        if(idx==dp.size()){
            dp.add(arr[i][1]);
        }else{
            dp.set(idx, arr[i][1]);   
        }
            
            
        }
        return dp.size();
        
    }
    
    //O(n^2)
     public  int solutionWithNormalLIS(int [][] arr){
        int omax = 0;
        
        int[]dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j=i-1;j>=0;j--) {
                
                if(dp[i]>j+1){
                    break;
                }
                
                if (arr[j][1] > arr[i][1] && arr[j][0]!=arr[i][0]) {
                    
                    if (dp[j] > max) {
                        
                        max = dp[j];
                        
                    }
                }
            }
            
            
            dp[i] = max + 1;
            omax = Math.max(dp[i], omax);
            
        }
       // System.out.println(omax);
          return omax;
    }
}
