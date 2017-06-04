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
    public int minMeetingRooms(Interval[] intervals) {
        Interval[] arr = new Interval[intervals.length * 2];
        for(int i = 0; i < intervals.length; i++) {
            arr[2 * i] = new Interval(intervals[i].start, 1);
            arr[2 * i + 1] = new Interval(intervals[i].end, -1);
        }
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if(a.start != b.start) return a.start - b.start;
                return a.end - b.end;
            }
        });
        int max = 0;
        int cur = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].end == 1) cur++;
            else cur--;
            max = Math.max(max, cur);
        }
        return max;
    }
}