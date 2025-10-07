import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] clothes = new int[n+2];
        Arrays.fill(clothes,1);
        for(int i : lost) clothes[i]--;
        for(int i : reserve) clothes[i]++;
        for(int i=1; i<=n; i++) {
            if(clothes[i]==0) {
                if(clothes[i-1]==2) {
                    clothes[i-1]--;
                    clothes[i]++;
                } else if(clothes[i+1]==2) {
                    clothes[i+1]--;
                    clothes[i]++;
                }
                else answer--;
            }
        }
        return answer;
    }
}