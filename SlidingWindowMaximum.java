public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];
        if(nums.length == 0) return new int[0];
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            if(i >= k && deq.peekLast() == nums[i - k]) deq.pollLast();
            while(!deq.isEmpty() && nums[i] > deq.peek()) deq.poll();
            deq.offerFirst(nums[i]);
            if(i - k + 1 >= 0) ret[i - k + 1] = deq.peekLast();
        }
        return ret;
    }
}