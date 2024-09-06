class Solution {
    private List<int[]> q = new ArrayList<>();  
    public void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        q.add(new int[] {x, y});
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                dfs(grid, nx, ny);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean foundIsland = false;
        for (int i = 0; i < n; i++) {
            if (foundIsland) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    foundIsland = true;
                    break;
                }
            }
        }

        int steps = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.remove(0);
                int x = cur[0];
                int y = cur[1];

              
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (grid[nx][ny] == 1) {
                           
                            return steps;
                        }
                        if (grid[nx][ny] == 0) {
                            grid[nx][ny] = 2;
                            q.add(new int[] {nx, ny});
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }

}