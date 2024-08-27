class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer>ans=new ArrayList<>();
        int n=security.length;
        int pre[]=new int[n];
        int suf[]=new int[n];
        int cnt=0;
        for(int i=1;i<n;i++){
           if(security[i]<=security[i-1]){
              cnt++;
           }else{
             cnt=0;
           }
           pre[i]=cnt;
        }
        cnt=0;
        for(int i=n-2;i>=0;i--){
           if(security[i]<=security[i+1]){
              cnt++;
           }else{
             cnt=0;
           }
           suf[i]=cnt;
        }
        for(int i=0;i<n;i++){
           if(pre[i]>=time && suf[i]>=time){
             ans.add(i);
           }
        }
        return ans;
    }
}