public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        double ret = find(nums1, nums2, 0, 0, l / 2 + 1);
        if(l % 2 == 0) ret = (ret + find(nums1, nums2, 0, 0, l / 2)) / 2;
        return ret;
    }
    
    private int find(int[] nums1, int[] nums2, int id1, int id2, int k) {
        if(id1 >= nums1.length) return nums2[id2 + k - 1];
        if(id2 >= nums2.length) return nums1[id1 + k - 1];
        if(k == 1) return Math.min(nums1[id1], nums2[id2]);
        int n1 = id1 + k / 2 - 1 < nums1.length ?
                nums1[id1 + k / 2 - 1] : Integer.MAX_VALUE;
        int n2 = id2 + k / 2 - 1 < nums2.length ?
                nums2[id2 + k / 2 - 1] : Integer.MAX_VALUE;
        if(n1 <= n2) return find(nums1, nums2, id1 + k / 2, id2, (k + 1) / 2);
        else return find(nums1, nums2, id1, id2 + k / 2, (k + 1) / 2);
	}
}