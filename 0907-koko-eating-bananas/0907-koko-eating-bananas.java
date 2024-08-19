import java.util.Arrays;
class Solution {
    public boolean check(long k, int[] b, long h) {
        long sum = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] % k == 0) {
                sum += (b[i] / k);
            } else {
                sum += (b[i] / k) + 1;
            }
        }
        return sum <= h;
    }

    public int minEatingSpeed(int[] b, int h) {
        long tr = 0;
        for (int i = 0; i < b.length; i++) {
            tr = Math.max(tr, (long) b[i]);
        }

        long low = 1, high = tr, u = 1, answer = -1;
        while (low <= high && u == 1) {
            long mid = (low + high) / 2;
            if (check(mid, b, h) == false) {
                low = mid + 1;
            } else {
                if (mid == 1) {
                    answer = 1;
                    u = 0;
                } else if (check(mid - 1, b, h) == false) {
                    answer = mid;
                    u = 0;
                } else {
                    high = mid - 1;
                }
            }
        }
        return (int) answer;
    }
}