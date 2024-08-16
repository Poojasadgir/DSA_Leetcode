class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int j = startCol; j <= endCol; j++) {
                list.add(matrix[startRow][j]);
            }
            startRow++; 

            
            for (int i = startRow; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }
            endCol--; 
           
            if (startRow <= endRow) {  
                for (int j = endCol; j >= startCol; j--) {
                    list.add(matrix[endRow][j]);
                }
                endRow--;
            }

           
            if (startCol <= endCol) {  
                for (int i = endRow; i >= startRow; i--) {
                    list.add(matrix[i][startCol]);
                }
                startCol++; 
            }
        }
        return list;
    }
}