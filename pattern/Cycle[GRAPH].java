//DFS    
Boolean isCyclicUtil(int v, Boolean visited[],
                         int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
 
            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
 
            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }
 
    // Returns true if the graph
    // contains a cycle, else false.
    Boolean isCyclic()
    {
 
        // Mark all the vertices as
        // not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int u = 0; u < V; u++) {
 
            // Don't recur for u if already visited
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;
        }
 
        return false;
    }


// BFS
   public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            parent[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(i, visited, parent)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    parent[neighbor] = current;
                } else if (parent[current] != neighbor) {
                    // Cycle detected
                    return true;
                }
            }
        }

        return false;
    }
