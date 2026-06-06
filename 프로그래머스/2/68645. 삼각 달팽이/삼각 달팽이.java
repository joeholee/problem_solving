import java.io.*;
import java.util.*;

class Solution {
    static final int dr[] = {1,0,-1};
    static final int dc[] = {0,1,-1};
    
    public int[] solution(int n) {
        int[][] adj = new int[n][n];
        int cr=-1, cc=0, dir=0, cur=1;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                cr+=dr[dir];
                cc+=dc[dir];
                adj[cr][cc]=cur++;
            }
            dir=(dir+1)%3;
        }
        int[] answer = new int[n*(n+1)/2];
        int idx=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                answer[idx++] = adj[i][j];
            }
        }
        return answer;
    }
}