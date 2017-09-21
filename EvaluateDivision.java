class Solution {
    
    private class Node {
        String str;
        Map<String, Double> neighbors;
        public Node(String str) {
            this.str = str;
            neighbors = new HashMap<>();
        }
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ret = new double[queries.length];
        Map<String, Node> map = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            map.putIfAbsent(equations[i][0], new Node(equations[i][0]));
            map.putIfAbsent(equations[i][1], new Node(equations[i][1]));
            map.get(equations[i][0]).neighbors.put(equations[i][1], values[i]);
            map.get(equations[i][1]).neighbors.put(equations[i][0], 1.0 / values[i]);
        }
        for(int i = 0; i < queries.length; i++) {
            if(!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])) {
                ret[i] = -1.0;
            } else {
                ret[i] = dfs(queries[i][0], queries[i][1], 1.0, map, new HashSet<>());
            }
        }
        return ret;
    }
    
    private double dfs(String a, String b, double val, Map<String, Node> map, Set<String> set) {
        if(a.equals(b)) {
            return val;
        }
        set.add(a);
        Map<String, Double> neighbors = map.get(a).neighbors;
        for(String str: neighbors.keySet()) {
            if(set.contains(str)) {
                continue;
            }
            double ret = dfs(str, b, val * neighbors.get(str), map, set);
            if(ret != -1.0) {
                return ret;
            }
        }
        return -1.0;
    }
}