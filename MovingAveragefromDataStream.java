public class MovingAverage {
    
    int[] arr;
    int sum;
    int i;
    int cnt;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sum = 0;
        i = 0;
        cnt = 0;
        arr = new int[size];
    }
    
    public double next(int val) {
        sum += val - arr[i];
        arr[i] = val;
        if(i < arr.length - 1) i++;
        else i = 0;
        if(cnt < arr.length) cnt++;
        return (double)sum / (double)cnt;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */