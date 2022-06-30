class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] factors = new int[n];
        factors[0] = 1;
        
        int ptr[] = new int[primes.length];
        
        
        
        for(int i=1;i<n;i++){
            
            int min = Integer.MAX_VALUE;
            for(int j=0;j<ptr.length;j++){
                long num = (long)primes[j] * (long)factors[ptr[j]];
                if( num > Integer.MAX_VALUE){
                    continue;
                }
                
                min = Math.min((int) num, min);
                
            }
            
            factors[i] = min;
            for(int j=0;j<ptr.length;j++){
                if((primes[j] * factors[ptr[j]]) == min){
                    ptr[j]++;
                } 
            }
            
            
        }
        
        
        return factors[n-1];
    }
}
