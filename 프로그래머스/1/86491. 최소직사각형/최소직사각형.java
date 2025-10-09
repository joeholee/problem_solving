class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int len = sizes.length;
        int maxW = 0;
        int maxH = 0;
        int maxWdx = -1;
        int maxHdx = -1;
        for(int i=0; i<len; i++) {
            if(sizes[i][0]>maxW) {
                maxW = sizes[i][0];
                maxWdx = i;
            }
            if(sizes[i][1]>maxH) {
                maxH = sizes[i][1];
                maxHdx = i;
            }
        }
        if(maxW>=maxH) {
            maxH = 0;
            for(int i=0; i<len; i++) {
                if(i==maxWdx) maxH = Math.max(maxH, sizes[i][1]);
                maxH = Math.max(maxH, Math.min(sizes[i][0], sizes[i][1]));
            }
        } else {
            maxW = 0;
            for(int i=0; i<len; i++) {
                if(i==maxHdx) maxW = Math.max(maxW, sizes[i][0]);
                maxW = Math.max(maxW, Math.min(sizes[i][0], sizes[i][1]));
            }
        }
        return maxW*maxH;
    }
}