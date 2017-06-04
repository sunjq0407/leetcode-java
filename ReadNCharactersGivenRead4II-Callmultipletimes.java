/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    int size;
    int offset;
    char[] remains;
    boolean eof;
    
    public Solution() {
        size = 0;
        offset = 0;
        remains = new char[3];
        eof = false;
    }
    
    public int read(char[] buf, int n) {
        int idx = 0;
        int cnt = 0;
        if(size != 0) {
            if(n < size) {
                for(int i = 0; i < n; i++)
                    buf[idx++] = remains[offset + i];
                size -= n;
                offset += n;
                return n;
            }
            for(int i = 0; i < size; i++)
                buf[idx++] = remains[offset + i];
            n -= size;
            cnt += size;
            size = 0;
            offset = 0;
        }
        if(n == 0 || eof) return cnt;
        char[] buf4 = new char[4];
        for(int i = 0; i < n / 4; i++) {
            int num = read4(buf4);
            cnt += num;
            for(int j = 0; j < num; j++)
                buf[idx++] = buf4[j];
            if(num < 4) return cnt;
        }
        if(n % 4 == 0) return cnt;
        int num = read4(buf4);
        if(num <= n % 4) {
            for(int i = 0; i < num; i++)
                buf[idx++] = buf4[i];
            return cnt + num;
        }
        eof = num != 4;
        size = num - n % 4;
        for(int i = 0; i < n % 4; i++)
            buf[idx++] = buf4[i];
        for(int i = 0; i < size; i++)
            remains[i] = buf4[i + n % 4];
        return cnt + n % 4;
    }
}