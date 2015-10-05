public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        int last = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(isBadVersion(mid)){
                hi = mid - 1;
                last = mid;
            }else{
                lo = mid + 1;
            }
        }
        return last;
    }
}