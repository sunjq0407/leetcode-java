/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length == 0) return 0;
        int max = 0;
        for(Point p : points) {
            Map<String, Integer> map = new HashMap<>();
            int vtc = 0;
            int dup = 0;
            for(Point i : points) {
                if(p.x == i.x && p.y == i.y) {
                    dup ++;
                    continue;
                }
                if(p.x == i.x) {
                    vtc ++;
                    continue;
                }
                int diffx = p.x - i.x;
                int diffy = p.y - i.y;
                boolean neg = (diffx > 0 && diffy < 0) || (diffx < 0 && diffy > 0);
                diffx = Math.abs(diffx);
                diffy = Math.abs(diffy);
                int gcd = gcd(diffx, diffy);
                diffx /= gcd;
                diffy /= gcd;
                String str = "";
                if(neg) str += "-";
                str += diffy + "/" + diffx;
                if(map.containsKey(str)) map.put(str, map.get(str) + 1);
                else map.put(str, 1);
            }
            for(int j : map.values())
                max = Math.max(max, j + dup);
            max = Math.max(max, vtc + dup);
        }
        return max;
    }
    
    private int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}