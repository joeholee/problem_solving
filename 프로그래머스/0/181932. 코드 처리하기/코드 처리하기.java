class Solution {
    public String solution(String code) {
        int mode = 0;
        String answer = "";
        for(int i=0; i<code.length(); i++) {
            if(code.charAt(i)=='1') {
                mode = 1-mode;
                continue;
            }
            if(mode==0) {
                if(i%2==0) answer+=code.charAt(i);
            }
            else {
                if(i%2==1) answer+=code.charAt(i);
            }
        }
        return answer.length() > 0 ? answer : "EMPTY";
    }
}