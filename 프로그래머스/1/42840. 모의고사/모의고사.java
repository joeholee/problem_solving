import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        scores[0] = calc(p1,answers);
        scores[1] = calc(p2,answers);
        scores[2] = calc(p3,answers);
        int maxScore = -1;
        for(int i : scores) maxScore = Math.max(maxScore, i);
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(scores[i]==maxScore) l.add(i+1);
        }
        int[] answer = new int[l.size()];
        for(int i=0; i<answer.length; i++) answer[i] = l.get(i);
        return answer;
    }
    
    int calc(int[] p, int[] answers) {
        int score = 0;
        for(int i=0; i<answers.length; i++) {
            if(answers[i]==p[i%p.length]) score++;
        }
        return score;
    }
}