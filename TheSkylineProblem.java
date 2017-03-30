public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] i : buildings) {
            height.add(new int[]{i[0], i[2]});
            height.add(new int[]{i[1], -i[2]});
        }
        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 1);
        int prev = -1;
        for(int[] h : height) {
            if(h[1] > 0) map.put(h[1], map.containsKey(h[1]) ? map.get(h[1]) + 1 : 1);
            else {
                if(map.get(-h[1]) == 1) map.remove(-h[1]);
                else map.put(-h[1], map.get(-h[1]) - 1);
            }
            int curH = map.firstKey();
            if(prev != curH) {
                ret.add(new int[]{h[0], curH});
                prev = curH;
            }
        }
        return ret;
    }
}