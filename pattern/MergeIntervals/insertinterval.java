class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length+1][2];
        int i=0;
        int j=0;
      
      // 3 step fill
      // 1st fill till we can reach a place for newInterval
      // 2nd fill in the new interval
      // fill in the remaining intervals while merging
      
        while(i<intervals.length && intervals[i][0]<newInterval[0]){
            ans[j] = intervals[i];
            i++;
            j++;
        }

        if(i==0 || ans[j-1][1]<newInterval[0]){
            ans[j] = newInterval;
            j++;
        }else{
            ans[j-1][1] = Math.max(ans[j-1][1], newInterval[1]);
        }

        while(i<intervals.length){

            if(ans[j-1][1]<intervals[i][0]){
                ans[j] = intervals[i];
                j++;
            }else{
                ans[j-1][1] = Math.max(ans[j-1][1], intervals[i][1]);
            }

            i++;

        }
    
    return Arrays.copyOf(ans, j);

    }
}
