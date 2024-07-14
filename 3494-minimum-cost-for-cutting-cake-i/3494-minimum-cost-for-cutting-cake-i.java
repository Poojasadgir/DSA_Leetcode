class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
       Integer[] horizontal = new Integer[horizontalCut.length];
        Arrays.setAll(horizontal, i -> horizontalCut[i]); 
        Integer[]vertical = new Integer[verticalCut.length];
        Arrays.setAll(vertical, i -> verticalCut[i]); 
        Arrays.sort(vertical,Collections.reverseOrder());
        Arrays.sort(horizontal,Collections.reverseOrder());
       
       int h=0,v=0;
       int hp=1,vp=1;
       int cost=0;

       while(h<horizontal.length && v< vertical.length){
          if(vertical[v]<=horizontal[h]){
             cost+=(horizontal[h]*vp);
             hp++;
             h++;
          }else{
            cost+=(vertical[v]*hp);
             vp++;
             v++;
          }
       }

       while(h<horizontal.length){
             cost+=(horizontal[h]*vp);
             hp++;
             h++;
       }
       while(v< vertical.length){
             cost+=(vertical[v]*hp);
             vp++;
             v++;
       }
       return cost;
    }
}