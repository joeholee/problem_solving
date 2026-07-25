import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0]=triangle[0][0];
        for(int r=1; r<n; r++) {
            for(int c=0; c<=r; c++) {
                if(c==0) dp[r][c] = dp[r-1][0]+triangle[r][c];
                else if(c==r) dp[r][c] = dp[r-1][c-1]+triangle[r][c];
                else dp[r][c] = Math.max(dp[r-1][c-1],dp[r-1][c])+triangle[r][c];
            }
        }
        int ret=0;
        for(int c=0; c<n; c++) ret=Math.max(ret,dp[n-1][c]);
        return ret;
    }
}