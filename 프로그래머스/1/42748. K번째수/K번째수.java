import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int l = commands[i][0];
            int r = commands[i][1];
            int idx = commands[i][2];
            int[] tmp = new int[r-l+1];
            for(int j=0; j<tmp.length; j++) tmp[j] = array[l+j-1];
            Arrays.sort(tmp);
            answer[i] = tmp[idx-1];
        }
        return answer;
    }
}