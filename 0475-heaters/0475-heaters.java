class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer>ts=new TreeSet<>();

        for(int h: heaters){
            ts.add(h);
        }

        int ans=0;

        for(int i=0;i<houses.length;i++){
            Integer leftHeater=ts.floor(houses[i]);//largest heater position ≤ the house position
            Integer rightHeater=ts.ceiling(houses[i]);//smallest heater position ≥ the house position

            int leftDist=Integer.MAX_VALUE;
            if(leftHeater!=null){
               leftDist=houses[i]-leftHeater;
            }
            
            int rightDist=Integer.MAX_VALUE;
            if(rightHeater!=null){
               rightDist=rightHeater-houses[i];
            }
            ans=Math.max(ans,Math.min(leftDist,rightDist));
        }
        return ans;
    }
}