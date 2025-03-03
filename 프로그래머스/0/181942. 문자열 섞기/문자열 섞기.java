class Solution {
    public String solution(String str1, String str2) {
        String ans = "";
        for(int i=0; i<str1.length(); i++) {
            ans+=str1.charAt(i);
            ans+=str2.charAt(i);
        }
        return ans;
    }
}