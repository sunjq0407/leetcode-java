public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		int i = 0;
		while(i < nums.length - 3) {
		    int j = i + 1;
			while(j < nums.length - 2) {
				int k = j + 1;
				int l = nums.length - 1;
				while(k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if(sum < target) k++;
					else if(sum > target) l--;
					else {
					    result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
					    while(++k < l && nums[k] == nums[k - 1]);
					    while(k < --l && nums[l] == nums[l + 1]);
					}
				}
				while(++j < nums.length - 2 && nums[j] == nums[j - 1]);
			}
			while(++i < nums.length - 3 && nums[i] == nums[i - 1]);
		}
		return result;
	}
}