import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String,Integer> name = new HashMap<>();
        Map<Integer,String> rank = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            name.put(players[i],i);
            rank.put(i,players[i]);
        }
        for(int i=0; i<callings.length; i++) {
            int idx = name.get(callings[i]);
            String val = rank.get(idx-1);
            name.put(callings[i],idx-1);
            name.put(val,idx);
            rank.put(idx-1,callings[i]);
            rank.put(idx,val);
        }
        answer = new String[players.length];
        for(int i=0; i<answer.length; i++) answer[i] = rank.get(i);
        return answer;
    }
}