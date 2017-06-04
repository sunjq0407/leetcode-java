/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int idx = 0;
        int cnt = 0;
        char[] buf4 = new char[4];
        for(int i = 0; i < n / 4; i++) {
            int num = read4(buf4);
            cnt += num;
            for(int j = 0; j < num; j++)
                buf[idx++] = buf4[j];
            if(num < 4) return cnt;
        }
        int num = read4(buf4);
        for(int i = 0; i < Math.min(num, n % 4); i++)
            buf[idx++] = buf4[i];
        return cnt + Math.min(num, n % 4);
    }
}