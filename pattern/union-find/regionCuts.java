class RegionCut {
    public static int regionsBySlashes(String[] grid) {
        
        int N = grid.length;
        UnionFind findUnion = new UnionFind(4 * N * N);

        // Traversing the list
        for (int r = 0; r < N; ++r) {

            for (int c = 0; c < N; ++c) {

                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);
                if ((val == '/') || (val == ' ')) {

                    // Connecting the north and west components of the box
                    findUnion.union(root + 0, root + 1);

                    // Connecting the east and south componeents of the box
                    findUnion.union(root + 2, root + 3);
                }

                if ((val == '\\') || (val == ' ')) {

                    // Connecting the north and east components of the box
                    findUnion.union(root + 0, root + 2);

                    // Connecting the west and south components of the box
                    findUnion.union(root + 1, root + 3);
                }

                // Connecting the south component of the current box with the north component of the box below it
                if (r + 1 < N)
                    findUnion.union(root + 3, (root + 4 * N) + 0);

                // Connecting the north component of the current box with the south component of the box above it
                if (r - 1 >= 0)
                    findUnion.union(root + 0, (root - 4 * N) + 3);
                
                // Connecting the east component of the current box with the west component of the box on its right
                if (c + 1 < N)
                    findUnion.union(root + 2, (root + 4) + 1);
                
                // Connecting the west component of the current box with the east component of the box on its left
                if (c - 1 >= 0)
                    findUnion.union(root + 1, (root - 4) + 2);
            }
        }

        // Finding the number of connected components
        int count = 0;
        for (int x = 0; x < 4 * N * N; ++x) {
            if (findUnion.find(x) == x)
                count++;
        }

        return count;
    }
    public static void main(String[] args) {

        String[][] inputs = {
            {
                "/\\",
                "\\/"
            },
            {
                " /",
                "  "
            },
            {
                " /",
                "/ "
            },
            {
                " /\\",
                "\\/ ",
                " \\ "
            },
            {
                 " \\/",
                 " /\\",
                  "\\/ "
            }
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput list of strings: " + Print.printGrid(inputs[i]));
            System.out.println("\tOutput: " + regionsBySlashes(inputs[i]));
            System.out.println(Print.repeat("-", 100));
        }

    }
}

