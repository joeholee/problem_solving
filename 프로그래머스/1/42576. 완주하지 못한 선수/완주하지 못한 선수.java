import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> marathon = new HashMap<>();
        for(String s : participant) marathon.put(s, marathon.getOrDefault(s,0)+1);
        for(String s : completion) marathon.put(s, marathon.get(s)-1);
        for(Map.Entry<String, Integer> e : marathon.entrySet()) {
            if(e.getValue()==1) {
                answer = e.getKey();
                break;
            }
        }
        return answer;
    }
}