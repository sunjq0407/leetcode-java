public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        if(nums.length == 0) {
            return ret;
        }
        Arrays.sort(nums);
        int[] ids = new int[nums.length];
        int[] cnt = new int[nums.length];
        int id = 0;
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            cnt[i] = 1;
            ids[i] = i;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && cnt[j] + 1 > cnt[i]) {
                    cnt[i] = cnt[j] + 1;
                    ids[i] = j;
                }
            }
            if(cnt[i] > max) {
                max = cnt[i];
                id = i;
            }
        }
        while(ret.size() == 0 || nums[id] != ret.get(0)) {
            ret.add(0, nums[id]);
            id = ids[id];
        }
        return ret;
    }
}