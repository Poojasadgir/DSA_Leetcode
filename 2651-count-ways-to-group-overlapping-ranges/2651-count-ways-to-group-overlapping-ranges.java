class Solution {
    static final int MOD = 1000000007;
    long power(long a, long n, long p) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * a) % p;
                n--;
            } else {
                a = (a * a) % p;
                n /= 2;
            }
        }
        return res;
    }
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(ranges[0]);

        for (int i = 1; i < ranges.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            if (ranges[i][0] > last[1]) {
                merged.add(ranges[i]);
            } else {
                last[1] = Math.max(last[1], ranges[i][1]);
            }
        }

        long ans = power(2, merged.size(), MOD);
        return (int) ans;
    }
}