import java.util.*;
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if(nums==null) return ans;
        int len =0;
        StringBuilder temp = null;
        for(int i=0; i<(len=nums.length);++i){
            int k = nums[i];
            temp = new StringBuilder();
            temp.append(nums[i]);
            while(i+1<len && nums[i+1] == nums[i]+1) ++i;
            if(nums[i]!=k){
                temp.append("->");
                temp.append(nums[i]);
            }
            ans.add(temp.toString());
        }
        return ans;
    }
}