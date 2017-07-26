public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums1) set.add(i);
        List<Integer> list = new ArrayList<>();
        for(int i : nums2) {
            if(set.contains(i)) {
                set.remove(i);
                list.add(i);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++) ret[i] = list.get(i);
        return ret;
    }
}