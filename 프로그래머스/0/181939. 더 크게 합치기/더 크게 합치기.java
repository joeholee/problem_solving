class Solution {
    public int solution(int a, int b) {
        String s1 = Integer.toString(a)+Integer.toString(b);
        String s2 = Integer.toString(b)+Integer.toString(a);
        return (Integer.parseInt(s1) >= Integer.parseInt(s2) ? Integer.parseInt(s1) : Integer.parseInt(s2));
    }
}