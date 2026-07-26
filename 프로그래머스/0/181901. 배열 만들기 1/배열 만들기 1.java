import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> li = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(i%k==0) li.add(i);
        }
        int[] ret = new int[li.size()];
        for(int i=0; i<ret.length; i++) ret[i] = li.get(i);
        return ret;
    }
}