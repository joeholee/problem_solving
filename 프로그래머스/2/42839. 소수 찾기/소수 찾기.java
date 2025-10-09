import java.util.*;

class Solution {
    boolean[] isPrime = new boolean[10000000];
    Set<Integer> s = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        Arrays.fill(isPrime, true);
        isPrime[0]=isPrime[1] = false;
        for(int i=2; i*i<=9999999; i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i; j<=9999999; j+=i) isPrime[j] = false;
        }
        dfs("", numbers);
        for(int i : s) if(isPrime[i]) answer++;
        return answer;
    }
    
    void dfs(String cur, String numbers) {
        if(cur!="") s.add(Integer.parseInt(cur));
        for(int i=0; i<numbers.length(); i++) {
            dfs(cur+numbers.charAt(i), numbers.substring(0,i)+numbers.substring(i+1));
        }
    }
}