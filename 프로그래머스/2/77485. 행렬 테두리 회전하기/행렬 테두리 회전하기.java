class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int[][] arr = new int[rows][columns];
        for(int r=0; r<rows; r++) {
            for(int c=0; c<columns; c++) arr[r][c] = r*columns+c+1;
        }
        for(int i=0; i<n; i++) {
            int x1=queries[i][0]-1, y1=queries[i][1]-1, x2=queries[i][2]-1, y2=queries[i][3]-1;
            int tmp = arr[x1][y1];
            int val = tmp;
            for(int r=x1; r<x2; r++) {
                arr[r][y1] = arr[r+1][y1];
                val = Math.min(val,arr[r][y1]);
            }
            for(int c=y1; c<y2; c++) {
                arr[x2][c] = arr[x2][c+1];
                val = Math.min(val,arr[x2][c]);
            }
            for(int r=x2; r>x1; r--) {
                arr[r][y2] = arr[r-1][y2];
                val = Math.min(val,arr[r][y2]);
            }
            for(int c=y2; c>y1; c--) {
                arr[x1][c] = arr[x1][c-1];
                val = Math.min(val,arr[x1][c]);
            }
            arr[x1][y1+1]=tmp;
            answer[i] = val;
        }
        return answer;
    }
}