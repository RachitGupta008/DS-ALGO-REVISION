//divide

import java.util.*;

class Solution {
    private Map<String, String> parents = new HashMap<>();
    private Map<String, Double> values = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] results = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            if (!parents.containsKey(x) || !parents.containsKey(y) || !find(x).equals(find(y))) {
                results[i] = -1.0d;
            } else {
                results[i] = divide(x) / divide(y);
            }
        }

        return results;
    }

    private void union(String parent, String child, double value) {
        if (!parents.containsKey(parent)) {
            parents.put(parent, parent);
            values.put(parent, 1.0d);
        }
        if (!parents.containsKey(child)) {
            parents.put(child, child);
            values.put(child, 1.0d);
        }

        String root1 = find(parent);
        String root2 = find(child);
        if (root1.equals(root2)) return;

        parents.put(root2, root1);
        values.put(root2, value * divide(parent) / divide(child));
    }

    private String find(String x) {
        if (parents.get(x).equals(x)) {
            return x;
        } else {
            String parent = find(parents.get(x));
            double value = values.get(x) * values.get(parents.get(x));
            parents.put(x, parent);
            values.put(x, value);
            return parent;
        }
    }

    private double divide(String x) {
        find(x);
        return values.get(x);
    }
}
