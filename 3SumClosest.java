public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0;
		int min = Integer.MAX_VALUE;
		int i = 0;
		while(i < nums.length - 2) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target) return sum;
				else if (sum < target) while(nums[j++] == nums[j] && j < k);
				else while(nums[k--] == nums[k] && j < k);
				int diff = Math.abs(sum - target);
				if(diff < min) {
				    result = sum;
				    min = diff;
				}
			}
			while(nums[i++] == nums[i] && i < nums.length - 2);
		}
		return result;
	}
}