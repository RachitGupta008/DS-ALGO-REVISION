class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(dist(b)-dist(a)));

        for(int i=0;i<k;i++){
            q.add(points[i]);
        }

        for(int i=k;i<points.length;i++){
            System.out.println(dist(q.peek()));
            if(dist(points[i])<dist(q.peek())){
                q.remove();
                q.add(points[i]);
            }

        }

        int[][] ans = new int[q.size()][2];
        int i=0;
        while(!q.isEmpty()){
            ans[i++] = q.remove();
        }
        return ans;
    }

    int dist(int b[]){
        return (b[0]*b[0]+b[1]*b[1]);
    }
}
