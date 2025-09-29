import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i : nums) s.add(i);
        int answer = 0;
        answer = Math.min(nums.length/2, s.size());
        return answer;
    }
}