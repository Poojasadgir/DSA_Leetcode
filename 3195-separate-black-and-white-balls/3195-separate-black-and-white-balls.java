class Solution {
    public long minimumSteps(String s) {
            int n=s.length(),last=0;
        long count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                count+=i-last;
                last++;
            }
        }
        return count;
    }
}