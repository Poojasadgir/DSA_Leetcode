//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] mat) {
        // Code here
      if(mat==null ||  mat.length==0)return 0;
      int r=mat.length;
      int c=mat[0].length;
      Queue<int[]>q=new LinkedList<>();
      int count_fresh=0;
      for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(mat[i][j]==2){
                q.offer(new int[]{i,j});
            }

            if(mat[i][j]!=0){
               count_fresh++;
            }
        }
      }

      if(count_fresh==0)return 0;

      int countMin=0,cnt=0;
      int dx[]={0,0,1,-1};
      int dy[]={1,-1,0,0};
      
      while(!q.isEmpty()){
         int size=q.size();
         cnt+=size;

         for(int i=0;i<size;i++){
            int point[]=q.poll();
            for(int j=0;j<4;j++){
                int x=point[0]+dx[j];
                int y=point[1]+dy[j];

                if(x<0 || y<0 || x>=r || y>=c || mat[x][y]==0 || mat[x][y]==2){
                    continue;
                }
                mat[x][y]=2;
                q.offer(new int[]{x,y});
            }
         }
         if(q.size()!=0){
           countMin++; 
         }
      }
      return  count_fresh==cnt? countMin:-1;
    }
}