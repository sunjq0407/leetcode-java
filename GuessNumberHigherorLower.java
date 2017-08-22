/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(l < r) {
            int mid = (r - l) / 2 + l;
            int result = guess(mid);
            if(result == 0) {
                return mid;
            } else if(result == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if(guess(l) == 0) {
            return l;
        } else {
            return r;
        }
    }
}