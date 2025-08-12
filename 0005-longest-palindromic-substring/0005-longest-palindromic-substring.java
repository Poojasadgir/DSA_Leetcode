class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int m=2*n+3;
        char sChars[]=new char[m];
        sChars[0]='@';
        sChars[m-1]='&';
        int t=1;
        for(int i=0;i<n;i++){
            sChars[t++]='#';
            sChars[t++]=s.charAt(i);
        }
        sChars[t]='#';
        int maxLen=1,start=0;
        int p[]=new int[m];
        for(int i=1;i<m-1;i++){
            while (sChars[i + p[i] + 1] == sChars[i - p[i] - 1]) {
               p[i]++;
            }
            if(p[i]>maxLen){
                start=(i-p[i])/2;
                maxLen=p[i];
            }
        }
        return s.substring(start, start + maxLen);
    }
}