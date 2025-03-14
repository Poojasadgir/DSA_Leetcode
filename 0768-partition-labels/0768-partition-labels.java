class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<s.length();){
         int start=i;
         int end=s.lastIndexOf(s.charAt(start));

        for(int j=start+1;j<=end-1;j++){
             int lastIndexOfNextChar=s.lastIndexOf(s.charAt(j));

             if(lastIndexOfNextChar>end){
                end=lastIndexOfNextChar;
             }
         }
         ans.add(end-start+1);
         i=end+1;
      }
      return ans;  
    }
}