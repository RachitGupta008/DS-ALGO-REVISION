https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/


import java.util.*;

class Solution {
    class DSU {
        int[] parent;
        Set<Integer> edges = new HashSet<>();

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        boolean union(int a, int b, int i) {
            int pa = find(a);
            int pb = find(b);

            if (pa != pb) {
                parent[pb] = pa;
                edges.add(i);
                return true;
            }
            return false;
        }

        int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] nedges = new int[edges.length][4];
        
        for (int i = 0; i < edges.length; i++) {
            System.arraycopy(edges[i], 0, nedges[i], 0, edges[i].length);
            nedges[i][3] = i;
        }
        
        Arrays.sort(nedges, Comparator.comparingInt(a -> a[2]));

        DSU uf = new DSU(n);
        int init = 0;
        for (int[] nedge : nedges) {
            int a = nedge[0];
            int b = nedge[1];
            int w = nedge[2];
            if (uf.union(a, b, nedge[3])) {
                init += w;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        for (int i = 0; i < nedges.length; i++) {
            DSU ignore = new DSU(n);
            int wt = 0;
            for (int[] nedge : nedges) {
                int a = nedge[0];
                int b = nedge[1];
                int w = nedge[2];
                if (i != nedge[3] && ignore.union(a, b, nedge[3])) {
                    wt += w;
                }
            }

            if (wt > init || ignore.edges.size() != n - 1) {
                ans.get(0).add(nedges[i][3]);
            } else {
                DSU forced = new DSU(n);
                forced.union(nedges[i][0], nedges[i][1], nedges[i][3]);
                int fw = nedges[i][2];

                for (int[] nedge : nedges) {
                    if (i != nedge[3] && forced.union(nedge[0], nedge[1], nedge[3])) {
                        fw += nedge[2];
                    }
                }

                if (fw == init) {
                    ans.get(1).add(nedges[i][3]);
                }
            }
        }
        return ans;
    }
}
