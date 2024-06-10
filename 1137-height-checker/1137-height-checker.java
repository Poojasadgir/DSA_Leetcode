class Solution {
    public int heightChecker(int[] heights) {
        int n=heights.length;
        int arr[]=new int[n];
        int m=arr.length;
        for(int i=0;i<m;i++){
         arr[i]=heights[i];
        }
        int count=0;
        Arrays.sort(arr);
        for(int i=0;i<m;i++){
         if(arr[i]!=heights[i]){
           count++;
         }
        }
        return count;
    }
}