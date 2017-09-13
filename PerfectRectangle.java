class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        int area = 0;
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        for(int[] rec : rectangles) {
            xMin = Math.min(xMin, rec[0]);
            yMin = Math.min(yMin, rec[1]);
            xMax = Math.max(xMax, rec[2]);
            yMax = Math.max(yMax, rec[3]);
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            helper(set, rec[0], rec[1]);
            helper(set, rec[0], rec[3]);
            helper(set, rec[2], rec[1]);
            helper(set, rec[2], rec[3]);
        }
        if(!set.contains(xMin + "#" + yMin) || !set.contains(xMin + "#" + yMax)
                || !set.contains(xMax + "#" + yMin) || !set.contains(xMax + "#" + yMax)
                || set.size() != 4) {
            return false;
        }
        return area == (xMax - xMin) * (yMax - yMin);
    }
    
    private void helper(Set<String> set, int a, int b) {
        String str = a + "#" + b;
        if(!set.add(str)) {
            set.remove(str);
        }
    }
}