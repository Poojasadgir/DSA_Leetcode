class Solution {
    public String longestPalindrome(String s) {
       int start=0,end=1;
       int l=0,r=0;

       for(int i=0;i<s.length();i++){
        l=i;
        r=i+1;
        
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(r-l+1 >end){
                start=l;
                end=r-l+1;
            }
            l--;
            r++;
        }
        l=i-1;
        r=i+1;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(r-l+1 >end){
                start=l;
                end=r-l+1;
            }
            l--;
            r++;
        }
       }
       String newstr="";
       for(int i=start;i<start+end;i++){
        newstr+=s.charAt(i);
       }
       return newstr;
    }
}