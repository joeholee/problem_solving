import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length, M = board[0].length;
        int[][] diff = new int[N+1][M+1];
        for(int[] s : skill) {
            int type=s[0], r1=s[1], c1=s[2], r2=s[3], c2=s[4], degree=s[5];
            int val = (type==1) ? -degree : degree;
            diff[r1][c1]+=val;
            diff[r1][c2+1]-=val;
            diff[r2+1][c1]-=val;
            diff[r2+1][c2+1]+=val;
        }
        for(int r=1; r<=N; r++) {
            for(int c=0; c<=M; c++) diff[r][c]+=diff[r-1][c];
        }
        for(int r=0; r<=N; r++) {
            for(int c=1; c<=M; c++) diff[r][c]+=diff[r][c-1];
        }
        int ret=0;
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(board[r][c]+diff[r][c]>=1) ret++;
            }
        }
        return ret;
    }
}