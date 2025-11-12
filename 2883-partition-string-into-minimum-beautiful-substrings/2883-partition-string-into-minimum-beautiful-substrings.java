class Solution {
    private String g;
    private int cl(int x, int y){
        int i = y;
        int c = 0;
        int b = 0;
        while (i >= x) {
            if (g.charAt(i) == '1') {
                c += Math.pow(2, b);
            }
            i--;
            b++;
        }
        return c;
    }
    public int minimumBeautifulSubstrings(String s){
        g = s;
        int[] dp = new int[16];
        Arrays.fill(dp, 100);
        dp[0] = 0;
        int G = s.length();
        int i = 0;
        while (i < G) {
            int answer = 100;
            int j = i;
            while (j >= 0) {
                int gValue = cl(j, i);
                if (s.charAt(j) != '0' && gValue != 0 && (15625 % gValue) == 0) {
                    answer = Math.min(answer, dp[j] + 1);
                }
                j--;
            }
            dp[i + 1] = answer;
            i++;
        }

        if (dp[G] == 100) {
            dp[G] = -1;
        }

        return dp[G];
    }
}