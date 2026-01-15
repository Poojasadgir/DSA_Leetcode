class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        int result[]=new int[n];
        Stack<Integer>st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]<=heights[i]){
                result[st.peek()]++;
                st.pop();
            }

            if(!st.isEmpty()){
                result[st.peek()]++;
            }
            st.push(i);
        }
        return result; 
    }
}