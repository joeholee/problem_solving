import java.io.*;
import java.util.*;

public class Main {
    static class Shortcut{
        int start, end, length;
        Shortcut(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    static int N, D; // 지름길의 수, 고속도로의 길이
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        List<Shortcut> shortcuts = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if(end <= D && (start-end < length)){
                shortcuts.add(new Shortcut(start, end, length));
            }
        }

        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for(int i = 0; i <= D; i++){
            if(i > 0) {
                dist[i] = Math.min(dist[i], dist[i - 1] + 1);
            }

            for(Shortcut shortcut : shortcuts) {
                if (shortcut.start == i && dist[i] + shortcut.length < dist[shortcut.end]) {
                    dist[shortcut.end] = dist[i] + shortcut.length;
                }
            }
        }
        System.out.println(dist[D]);

    }
}