    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

// The presence of recursion stack handles the case where a vertex can be reached from different edges
// the cycle will only be present if in a particular dfs that vertex is somehow reached again

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recursionStack) {
        visited[v] = true;
        recursionStack[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recursionStack)) {
                return true;
            } else if (recursionStack[neighbor]) {
                // Cycle detected
                return true;
            }
        }

        recursionStack[v] = false;
        return false;
    }
