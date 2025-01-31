//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private void dfs(int row, int col, 
        int[][] ans, 
        int[][] image, 
        int newColor, int delRow[], int delCol[], 
        int iniColor) { 
        ans[row][col] = newColor; 
        int n = image.length; 
        int m = image[0].length; 
        for(int i=0;i<4;i++) { 
        int nrow = row + delRow[i]; 
        int ncol = col + delCol[i]; 
        if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && 
        image [nrow] [ncol] == iniColor && ans [nrow] [ncol] != newColor) { 
        dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor); 
     } 
     } 
} 
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int iniColor = image [sr][sc]; 
        int[][] ans = image; 
        int delRow[] = {-1, 0, +1, 0}; 
        int delCol[] = {0, 1, 0, -1}; 
        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor); 
        return ans; 
    }
}