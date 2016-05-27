public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, 0, nums.length - 1, target);
        int right = searchRight(nums, 0, nums.length - 1, target);
        return new int[]{left, right};
    }
    
    private int searchLeft(int[] nums, int i, int j, int target) {
        if(i == j) return nums[i] == target ? i: -1;
        int index = i / 2 + j / 2;
        if(nums[index] == target && (index == 0 || nums[index - 1] != target)) return index;
        if(nums[index] < target) return searchLeft(nums, index + 1, j, target);
        else return searchLeft(nums, i, index, target);
    }
    
    private int searchRight(int[] nums, int i, int j, int target) {
        if(i == j) return nums[i] == target ? i: -1;
        int index = i / 2 + j / 2;
        if(nums[index] == target && (index == nums.length - 1 || nums[index + 1] != target)) return index;
        if(nums[index] <= target) return searchRight(nums, index + 1, j, target);
        else return searchRight(nums, i, index, target);
    }
}