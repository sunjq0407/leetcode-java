public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left = searchCol(image, 0, y, true);
        int right = searchCol(image, y + 1, image[0].length, false);
        int top = searchRow(image, 0, x, true);
        int bot = searchRow(image, x + 1, image.length, false);
        return (right - left) * (bot - top);
    }
    
    private int searchCol(char[][] image, int l, int r, boolean small) {
        while(l < r) {
            int mid = (l + r) / 2;
            int i = 0;
            for(; i < image.length; i++)
                if(image[i][mid] == '1') break;
            if(small) {
                if(i < image.length) r = mid;
                else l = mid + 1;
            } else {
                if(i < image.length) l = mid + 1;
                else r = mid;
            }
        }
        return l;
    }
    
    private int searchRow(char[][] image, int l, int r, boolean small) {
        while(l < r) {
            int mid = (l + r) / 2;
            int i = 0;
            for(; i < image[0].length; i++)
                if(image[mid][i] == '1') break;
            if(small) {
                if(i < image[0].length) r = mid;
                else l = mid + 1;
            } else {
                if(i < image[0].length) l = mid + 1;
                else r = mid;
            }
        }
        return l;
    }
}