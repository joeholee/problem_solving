import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length, N = lock.length;
        int[][] newLock = new int[N*3][N*3];
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                newLock[r+N][c+N] = lock[r][c];
            }
        }
        int[][] curKey = key;
        for(int dir=0; dir<4; dir++) {
            curKey = rotate90(curKey);
            for(int r=0; r<=N*2; r++) {
                for(int c=0; c<=N*2; c++) {
                    addKey(newLock, curKey, r, c, M);
                    if(check(newLock, N)) return true;
                    subKey(newLock, curKey, r, c, M);
                }
            }
        }
        return false;
    }
    
    int[][] rotate90(int[][] key) {
        int[][] ret = new int[key.length][key.length];
        for(int r=0; r<key.length; r++) {
            for(int c=0; c<key.length; c++) {
                ret[c][key.length-r-1] = key[r][c];
            }
        }
        return ret;
    }
    
    void addKey(int[][] newLock, int[][] key, int startR, int startC, int M) {
        for(int r=0; r<M; r++) {
            for(int c=0; c<M; c++) {
                newLock[startR+r][startC+c]+=key[r][c];
            }
        }
    }
    
    void subKey(int[][] newLock, int[][] key, int startR, int startC, int M) {
        for(int r=0; r<M; r++) {
            for(int c=0; c<M; c++) {
                newLock[startR+r][startC+c]-=key[r][c];
            }
        }
    }
    
    boolean check(int[][] newLock, int N) {
        for(int r=N; r<N*2; r++) {
            for(int c=N; c<N*2; c++) {
                if(newLock[r][c]!=1) return false;
            }
        }
        return true;
    }
}