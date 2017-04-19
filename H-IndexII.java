public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int l = 0;
        int r = citations.length - 1;
        while(l < r) {
            int mid = (r - l) / 2 + l;
            if(citations[mid] >= citations.length - mid) r = mid;
            else l = mid + 1;
        }
        if(citations[l] >= citations.length - l) return citations.length - l;
        return 0;
    }
}