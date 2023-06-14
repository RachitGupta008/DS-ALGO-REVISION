https://leetcode.com/problems/last-day-where-you-can-still-cross/editorial/ -- good solution with binary search
class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        UnionFind uf = new UnionFind(row, col);

        int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        int ln = 0;
        int rn = row*col+1;

        int[][] matrix = new int[row][col];
        int days = 0;
        System.out.println(row+" "+col);
        for(int i=0;i<cells.length;i++){

            int r = cells[i][0]-1;
            int c = cells[i][1]-1;
            //System.out.println(r+" "+c);
            matrix[r][c] = 1;

            for(int j=0;j<dirs.length;j++){
                int rd = r+dirs[j][0];
                int cd = c + dirs[j][1];
                

                if(isValid(rd, cd, row, col) && matrix[rd][cd]==1){
                    System.out.println(rd+" "+cd);
                    uf.union(rd*col+cd+1, r*col+c+1);
                }



            }
            if(c==0){
                uf.union(ln, r*col+c+1);
            }
            if(c==col-1){
                uf.union(rn, r*col+c+1);
            }

            System.out.println("rn"+uf.find(rn)+" "+uf.find(ln));
            if(uf.find(rn) == uf.find(ln)){
                break;
            }

            days++;


        }

        return days;





    }

    boolean isValid(int r, int c, int rows, int cols){

        return r<rows && r>=0 && c<cols &&c>=0;
    }

     class UnionFind {
        int[] father;  
        int m, n;
        int count = 0;
        UnionFind(int row, int col) {  
            m = row;  
            n = col;  
            father = new int[m*n+2];  
            for (int i = 0; i < m; i++) {  
                for (int j = 0; j < n; j++) {  
                    
                        int id = i * n + j+1;
                        father[id] = id;
                        count++;
                }  
            }
            father[0] = 0;
            father[m*n+1] = m*n+1;  
        }
        public void union(int node1, int node2) {
            System.out.println("Attaching" + node1+" "+node2);
            int find1 = find(node1);
            int find2 = find(node2);
            if(find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }
        public int find (int node) {  
            if (father[node] == node) {  
                return node;
            }
            father[node] = find(father[node]);  
            return father[node];
        }
    }

}
