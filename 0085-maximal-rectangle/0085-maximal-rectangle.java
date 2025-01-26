class Solution {
    public int largestRectangleArea(int[] heights) {
      int MaxArea=0;
      if(heights.length==1){
        return heights[0];
      }
      int nsr[]=new int[heights.length]; 
      int nsl[]=new int[heights.length];

      Stack<Integer>s=new Stack<>();

      for(int i=heights.length-1;i>=0;i--){
          while(!s.isEmpty() && heights[s.peek()]>=heights[i]) {
            s.pop();
          }
          if(s.isEmpty()){
            nsr[i]=heights.length;
          }else{
            nsr[i]=s.peek();
          }
          s.push(i);
      }
       s=new Stack<>();
        for(int i=0;i<heights.length;i++){
             while(!s.isEmpty() && heights[s.peek()]>=heights[i]) {
            s.pop();
          }
          if(s.isEmpty()){
            nsl[i]=-1;
          }else{
            nsl[i]=s.peek();
          }
          s.push(i);
        }

       for(int i=0;i<heights.length;i++){
         int height=heights[i];
         int width=nsr[i]-nsl[i]-1;
         int currArea=height*width;
         MaxArea=Math.max(currArea,MaxArea);  
       }
       return MaxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] histogram = new int[m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j] += 1;
                } else {
                    histogram[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(histogram));
        }

        return maxArea;

    }
}