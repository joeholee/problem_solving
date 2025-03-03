class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        if(len1==len2) {
            int sum1 = 0;
            int sum2 = 0;
            for(int i : arr1) sum1+=i;
            for(int i : arr2) sum2+=i;
            return (sum1 > sum2 ? 1 : (sum1 == sum2) ? 0 : -1);
        }
        return (len1 > len2 ? 1 : -1);
    }
}