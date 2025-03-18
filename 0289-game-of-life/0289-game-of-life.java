class Solution {
    public boolean isSafe(int i,int j,int board[][]){
        int n=board.length;
        int m=board[0].length;
        return (i>=0 && i<n && j>=0 && j<m);
    }
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;

        int xDir[]={-1,-1,-1,0,0,1,1,1};
        int yDir[]={-1,0,1,-1,1,-1,0,1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count=0;
                for(int k=0;k<8;k++){
                   int currX=i+xDir[k];
                   int currY=j+yDir[k];
                   if(isSafe(currX,currY,board) && Math.abs(board[currX][currY])==1){
                     count++;
                   }
                }
                if(board[i][j]==1 && (count<2 || count>3)){
                    board[i][j]=-1;
                }
                if(board[i][j]==0 && (count==3)){
                    board[i][j]=2;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]>=1){
                    board[i][j]=1;
                }else{
                    board[i][j]=0;
                }
            }
        }
    }    
}