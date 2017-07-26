public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            if(!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : nums2) {
            if(map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                list.add(i);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++) ret[i] = list.get(i);
        return ret;
    }
}