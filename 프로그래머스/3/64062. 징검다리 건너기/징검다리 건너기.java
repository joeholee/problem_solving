import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int ret=0;
        int st=1, en=200000000;
        while(st<=en) {
            int mid = (st+en)/2;
            if(isPossible(stones,k,mid)) {
                ret=mid;
                st=mid+1;
            } else en=mid-1;
        }
        return ret;
    }
    
    boolean isPossible(int[] stones, int k, int mid) {
        int cnt=0;
        for(int stone : stones) {
            if(stone<mid) {
                cnt++;
                if(cnt==k) return false;
            } else cnt=0;
        }
        return true;
    }
}