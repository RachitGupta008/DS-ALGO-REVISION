// This algo works for the -ive edge cycle also
// intuition is that if there are V vertex, then it will only take V-1 iteration to calculate the minimum distance.
// Since for i=0, it will start with 0 and only update the distance that are connected with the vertex 0
// for i=1, it will update the distance of each vertex that is 1 vertex away from the source vertex
// at i=v-1 it will update the distace of each vertex that is v-1 vertex away from source
// wich eventually covers all the vertexes.

// If at i==v there is an update to a vertex, this will signify a -ive edge cycle.

static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int)(1e8);
        dist[S] = 0;
        // V x E
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
