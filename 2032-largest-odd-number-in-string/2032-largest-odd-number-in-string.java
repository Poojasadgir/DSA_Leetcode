class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
        String ans="";
        int res=-1;
        char temp[]=num.toCharArray();
        for(int i=n-1;i>=0;i--){
            int nums=temp[i]-'a';
            if(nums%2==0){
               res=i;
                break;
            }
        }
        for(int i=0;i<=res;i++){
          ans+=temp[i];
        }
        return ans;
    } 
}