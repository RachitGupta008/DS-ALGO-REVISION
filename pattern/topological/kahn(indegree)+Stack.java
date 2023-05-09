// This algo is based on indegree
// we first add all nodes with zero indegree
// after that we go to child and decrement the indegree as if parent was not there since parent was visited, then if child indegree becomes zero
// then it is guaranteed that we can visit child

List<Character> sortedOrder = new ArrayList<>();
        
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>(); 
        for( int x = 0; x < dependencies.size(); x++){
            char parent = dependencies.get(x).get(0);
            char child = dependencies.get(x).get(1);
            graph.put(parent, new ArrayList<>());
            graph.put(child, new ArrayList<>());
            inDegree.put(parent, 0);
            inDegree.put(child, 0);
        }
        if(graph.size() <= 0){
            return sortedOrder;
        }

        for (int dependency = 0; dependency < dependencies.size(); dependency++){
            char parent = dependencies.get(dependency).get(1);
            char child = dependencies.get(dependency).get(0);
            graph.get(parent).add(child); 
            inDegree.put(child, inDegree.get(child) + 1);
        }
        Queue<Character> sources = new LinkedList<>();
        for(char key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                sources.add(key);
            }
        }

        while(!sources.isEmpty()){
            char vertex = sources.poll();
            
            sortedOrder.add(vertex);
            for(int child = 0; child < graph.get(vertex).size(); child++){
                inDegree.put(graph.get(vertex).get(child), inDegree.get(graph.get(vertex).get(child)) -1);
                if(inDegree.get(graph.get(vertex).get(child)) == 0){
                    sources.add(graph.get(vertex).get(child));
                }
            }
        }

        if(sortedOrder.size() != graph.size()){
            return new ArrayList<>();
        }
        return sortedOrder;




// 2ND ALGO
// Based on DFS
// Here we use a stack with dfs and after visiting the node and its children we put it into the stack
// the stack ensures that the parent comes above the child which clears the dependency since parent will always come first in order thereby getting a topological order


   void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent
        // to thisvertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
 
        // Push current vertex to stack
        // which stores result
        stack.push(new Integer(v));
    }
 
    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();
 
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
 
        // Print contents of stack
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }


   // Main recursive function to print all possible
    // topological sorts
// All topological sort
// other solution also exist we are not going there yet

    private void allTopologicalSortsUtil(boolean[] visited,
                        int[] indegree, ArrayList<Integer> stack) {
        // To indicate whether all topological are found
        // or not
        boolean flag = false;
 
        for (int i = 0; i < this.V; i++) {
            // If indegree is 0 and not yet visited then
            // only choose that vertex
            if (!visited[i] && indegree[i] == 0) {
                 
                // including in result
                visited[i] = true;
                stack.add(i);
                for (int adjacent : this.adjListArray[i]) {
                    indegree[adjacent]--;
                }
                allTopologicalSortsUtil(visited, indegree, stack);
                 
                // resetting visited, res and indegree for
                // backtracking
                visited[i] = false;
                stack.remove(stack.size() - 1);
                for (int adjacent : this.adjListArray[i]) {
                    indegree[adjacent]++;
                }
 
                flag = true;
            }
        }
        // We reach here if all vertices are visited.
        // So we print the solution here
        if (!flag) {
            stack.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
 
    }
     
    // The function does all Topological Sort.
    // It uses recursive alltopologicalSortUtil()
    public void allTopologicalSorts() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[this.V];
 
        int[] indegree = new int[this.V];
 
        for (int i = 0; i < this.V; i++) {
 
            for (int var : this.adjListArray[i]) {
                indegree[var]++;
            }
        }
 
        ArrayList<Integer> stack = new ArrayList<>();
 
        allTopologicalSortsUtil(visited, indegree, stack);
    }
