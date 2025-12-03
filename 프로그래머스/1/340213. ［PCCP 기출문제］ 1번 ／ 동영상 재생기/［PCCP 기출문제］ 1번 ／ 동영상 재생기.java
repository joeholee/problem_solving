import java.util.StringTokenizer;

class Solution {
    static StringTokenizer st;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        st = new StringTokenizer(video_len, ":");
        int tot_min = Integer.parseInt(st.nextToken());
        int tot_sec = Integer.parseInt(st.nextToken());
        int tot_len = 60*tot_min+tot_sec;
        
        st = new StringTokenizer(pos, ":");
        int cur_min = Integer.parseInt(st.nextToken());
        int cur_sec = Integer.parseInt(st.nextToken());
        int cur_len = 60*cur_min+cur_sec;
        
        st = new StringTokenizer(op_start, ":");
        int start_min = Integer.parseInt(st.nextToken());
        int start_sec = Integer.parseInt(st.nextToken());
        int start_len = 60*start_min+start_sec;
        
        st = new StringTokenizer(op_end, ":");
        int end_min = Integer.parseInt(st.nextToken());
        int end_sec = Integer.parseInt(st.nextToken());
        int end_len = 60*end_min+end_sec;
        
        for(String str : commands) {
            if(cur_len>=start_len&&cur_len<=end_len) cur_len=end_len;
            switch (str) {
                case "prev":
                    cur_len-=10;
                    if(cur_len<0) cur_len=0;
                    if(cur_len>=start_len&&cur_len<=end_len) cur_len=end_len;
                    break;
                case "next":
                    cur_len+=10;
                    if(cur_len>tot_len) cur_len=tot_len;
                    if(cur_len>=start_len&&cur_len<=end_len) cur_len=end_len;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        String ans_min = cur_len/60+"";
        String ans_sec = cur_len%60+"";
        sb.append(ans_min.length()==1 ? "0" : "").append(ans_min).append(":").append(ans_sec.length()==1 ? "0" : "").append(ans_sec);
        String answer = sb.toString();
        return answer;
    }
}