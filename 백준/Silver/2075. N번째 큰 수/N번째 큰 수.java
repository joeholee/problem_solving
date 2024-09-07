import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int r=0; r<N; r++) {
            String[] row = br.readLine().split(" ");
            for(int c=0; c<N; c++) pq.add(Integer.parseInt(row[c]));
        }
        for(int i=0; i<N-1; i++) pq.poll();
        System.out.println(pq.poll());
    }
}