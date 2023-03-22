//Intuition
// How would you do it if you dont have any code
// 1st we will get a list of project which we can do with the capital w
// 2nd we will select the one giving us the max profit
// we would repeat the process untill we do the project k or there is no available project that can be done with w capital



class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Queue<Integer> capq = new PriorityQueue<>((a,b)->capital[a]-capital[b]);
        Queue<Integer> pq = new PriorityQueue<>((a,b)->profits[b]-profits[a]);

        for(int i=0;i<capital.length;i++){
            capq.add(i);
        }

        for(int i=1;i<=k;i++){
        // This is 1st
            while(!capq.isEmpty() && capital[capq.peek()]<=w){
                pq.add(capq.remove());
            }
            //System.out.println(pq.size());
            if(pq.isEmpty()){
                return w;
            }
          // This is 2nd
            w = w+profits[pq.remove()];


        }

        return w;



        
    }
}
