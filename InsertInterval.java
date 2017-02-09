/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();
        int i = 0;
        for(; i < intervals.size(); i++) {
            if(newInterval.start <= intervals.get(i).end) break;
            else ret.add(intervals.get(i));
        }
        if(ret.size() == intervals.size()) {
            ret.add(newInterval);
            return ret;
        }
        Interval merge = intervals.get(i);
        if(newInterval.end < merge.start) {
            ret.add(newInterval);
            ret.add(merge);
        } else {
            merge.start = Math.min(merge.start, newInterval.start);
            merge.end = Math.max(merge.end, newInterval.end);
            ret.add(merge);
        }
        for(i++; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            Interval last = ret.get(ret.size() - 1);
            if(last.start <= cur.start && cur.start <= last.end)
                last.end = Math.max(last.end, cur.end);
            else ret.add(cur);
        }
        return ret;
    }
}