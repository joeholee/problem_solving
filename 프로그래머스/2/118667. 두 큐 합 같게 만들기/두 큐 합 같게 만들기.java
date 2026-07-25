import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1=0, sum2=0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int i : queue1) {
            q1.offer(i);
            sum1+=i;
        }
        for(int i : queue2) {
            q2.offer(i);
            sum2+=i;
        }
        long tgt = (sum1+sum2)/2;
        if(((sum1+sum2)%2)==1) return -1;
        int ret=0;
        int limit=queue1.length*4;
        while(sum1!=tgt) {
            if(ret>limit) return -1;
            if(sum1>tgt) {
                int val = q1.poll();
                sum1-=val;
                q2.offer(val);
            } else {
                int val = q2.poll();
                sum1+=val;
                q1.offer(val);
            }
            ret++;
        }
        return ret;
    }
}