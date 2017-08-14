public class HitCounter {
    
    private static final int HIT_LAST_TIME = 300;
    int cnt;
    LinkedList<Integer> hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        cnt = 0;
        hits = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits.offer(timestamp);
        cnt ++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!hits.isEmpty() && hits.peek() <= timestamp - HIT_LAST_TIME) {
            hits.poll();
            cnt --;
        }
        return cnt;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */