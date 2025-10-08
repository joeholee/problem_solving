class Solution {
    public int solution(String name) {
        int answer = 0;
        int[] count = new int[26];
        for(char c : name.toCharArray()) count[c-'A']++;
        for(int i=0; i<26; i++) answer+=count[i]*Math.min(i, 26-i);
        int n = name.length();
        int mv = n-1;
        for(int i=0; i<n; i++) {
            int nxt = i+1;
            while(nxt<n&&name.charAt(nxt)=='A') nxt++;
            mv = Math.min(mv, Math.min(i*2+n-nxt, (n-nxt)*2+i));
        }
        answer+=mv;
        return answer;
    }
}