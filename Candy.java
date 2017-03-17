public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int[] cnt = new int[ratings.length];
        Arrays.fill(cnt, 1);
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1])
                cnt[i] = cnt[i - 1] + 1;
        for(int i = ratings.length - 2; i >= 0; i--)
            if(ratings[i] > ratings[i + 1] && cnt[i] <= cnt[i + 1])
                cnt[i] = cnt[i + 1] + 1;
        int total = 0;
        for(int i = 0; i < ratings.length; i++) total += cnt[i];
        return total;
    }
}