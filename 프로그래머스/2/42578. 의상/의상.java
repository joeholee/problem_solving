import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int len = clothes.length;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
            String item = clothes[i][0];
            String cat = clothes[i][1];
            map.put(cat, map.getOrDefault(cat,0)+1);
        }
        int answer = 1;
        for(int val : map.values()) answer*=(val+1);
        return answer-1;
    }
}