class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<String[]> stk = new Stack<>();
        int[] ans = new int[n];

        for(int i=0;i<logs.size();i++){

            String log = logs.get(i);

            String[] points = log.split(":");
            //System.out.println(points[1]);
            if(points[1].equals("start")){
                stk.push(points);
            }else{

                String[] pts2 = stk.pop();

                int idx = Integer.parseInt(pts2[0]);

                int cnt = Integer.parseInt(points[2]) - Integer.parseInt(pts2[2])+1;
               // System.out.println(cnt);

                ans[idx] = ans[idx] + cnt;
               // System.out.println(stk);
                if(!stk.isEmpty()){
                 String[] pts3 = stk.peek();
                 ans[Integer.parseInt(pts3[0])] = ans[Integer.parseInt(pts3[0])] - cnt;
                

                }


            }

        }
        return ans;



    }
}
