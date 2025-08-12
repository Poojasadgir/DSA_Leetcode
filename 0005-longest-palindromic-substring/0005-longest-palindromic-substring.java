class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String MaxP = "";
        int maxLen = 1, start = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 
                int flag = 1;
                for (int k = 0; k < (j - i + 1) / 2; k++) { 
                    if (s.charAt(i + k) != s.charAt(j - k)) {
                        flag = 0;
                        break;
                    }
                }
                if (flag != 0 && (j - i + 1) > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        for (int x = start; x < start + maxLen; x++) {
            MaxP += s.charAt(x);
        }

        return MaxP;
    }
}