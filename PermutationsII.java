public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        List<List<Integer>> ret = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), ret, map);
        return ret;
    }
    
    private void helper(int[] nums, List<Integer> l, List<List<Integer>> ret,
            HashMap<Integer, Integer> map) {
        if(l.size() == nums.length) {
            ret.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) > 0) {
                l.add(nums[i]);
                map.put(nums[i], map.get(nums[i]) - 1);
                helper(nums, l, ret, map);
                map.put(nums[i], map.get(nums[i]) + 1);
                l.remove(l.size() - 1);
            }
            while(i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }
}