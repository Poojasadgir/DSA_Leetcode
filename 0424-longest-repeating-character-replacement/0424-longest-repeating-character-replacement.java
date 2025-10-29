class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int left = 0, right = 0;
        int maxFreq = 0, maxLen = 0;

        while (right < s.length()) {
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
                maxFreq = 0;
            }

            if ((right - left + 1) - maxFreq <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }
}