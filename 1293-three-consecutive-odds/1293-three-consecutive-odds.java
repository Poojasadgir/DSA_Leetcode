class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if((i<arr.length-2) &&((arr[i]%2!=0) && (arr[i+1]%2!=0)&& (arr[i+2]%2!=0))){
                return true;
            }
        }
        return false;
    }
}