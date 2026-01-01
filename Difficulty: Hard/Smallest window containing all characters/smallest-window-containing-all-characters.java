class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        int n = s.length();
        int m = p.length();

        if (m > n) return "";

        int arr[] = new int[128];

        // store frequency of pattern characters
        for (char c : p.toCharArray()) {
            arr[c]++;
        }

        int req = m;
        int bestLeft = 0;
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < n; right++) {

            if (--arr[s.charAt(right)] >= 0) {
                req--;
            }

            while (req == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    bestLeft = left;
                }

                if (++arr[s.charAt(left)] > 0) {
                    req++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" 
               : s.substring(bestLeft, bestLeft + minLen);
    }
}