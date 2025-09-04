class Solution {
    public void reverse(int row[]){
        int left=0,right=row.length-1;
        while(left<right){
            int temp=row[left];
            row[left]=row[right];
            row[right]=temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
    }
}