//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
     public void dfs(int i,int j,int n,int m,char grid[][]){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]!='1'){
            return;
        }
        
        if(grid[i][j]=='1'){
            grid[i][j]='0';
            dfs(i-1,j,n,m,grid);
            dfs(i+1,j,n,m,grid);
            dfs(i,j-1,n,m,grid);
            dfs(i,j+1,n,m,grid);
            dfs(i - 1, j - 1, n, m, grid); 
            dfs(i - 1, j + 1, n, m, grid); 
            dfs(i + 1, j - 1, n, m, grid);
            dfs(i + 1, j + 1, n, m, grid);
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,n,m,grid);
                }
            }
        }
        return cnt;
    }
}