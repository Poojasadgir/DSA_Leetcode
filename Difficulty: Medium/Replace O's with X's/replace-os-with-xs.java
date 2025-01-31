//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            char mat[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S[] = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = S[j].charAt(0);
                }
            }

            Solution ob = new Solution();
            char[][] ans = ob.fill(mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void dfs(int row,int col,int vis[][],char mat[][],int delrow[],int delcol[]){
        int n=mat.length;
        int m=mat[0].length;
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
              if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&vis[nrow][ncol]==0 && mat[nrow][ncol]=='O'){
                dfs(nrow,ncol,vis,mat,delrow,delcol);
           } 
        }
    }
    static char[][] fill(char mat[][]) {
        // code here
        int delrow[]={1,0,-1,0};
        int delcol[]={0,1,0,-1};
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        
        for(int j=0;j<m;j++){
           if(vis[0][j]==0 && mat[0][j]=='O'){
               dfs(0,j,vis,mat,delrow,delcol);
           } 
           if(vis[n-1][j]==0 && mat[n-1][j]=='O'){
               dfs(n-1,j,vis,mat,delrow,delcol);
           } 
        }
        
        for(int i=0;i<n;i++){
           if(vis[i][0]==0 && mat[i][0]=='O'){
               dfs(i,0,vis,mat,delrow,delcol);
           } 
           
           if(vis[i][m-1]==0 && mat[i][n-1]=='O'){
               dfs(i,m-1,vis,mat,delrow,delcol);
           } 
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]=='O' && vis[i][j]==0){
                    mat[i][j]='X';
                }
            }
        }
        return mat;
 }
}