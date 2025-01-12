class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int low = 0;  
        int high = 0;
           for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low = Math.max(low - 1, 0); 
                high--;
            } else if (c == '*') {
                low = Math.max(low - 1, 0); 
                high++;                    
            }
            if (high < 0) {
                return false;
            }
        }
        return low==0;
    }
}