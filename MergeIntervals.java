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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> ret = new ArrayList<>();
        ret.add(intervals.get(0));
        for(Interval i : intervals) {
            Interval last = ret.get(ret.size() - 1);
            if(last.start <= i.start && i.start <= last.end)
                last.end = Math.max(last.end, i.end);
            else ret.add(i);
        }
        return ret;
    }
}