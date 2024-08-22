import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] w;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        w = new int[2*n];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<2*n; i++) w[i]=Integer.parseInt(input[i]);
        Arrays.sort(w);
        int min = w[0]+w[2*n-1];
        for(int i=1; i<=n-1; i++) {
            int tmp = w[i]+w[2*n-1-i];
            if(min>tmp) min=tmp;
        }
        System.out.print(min);
    }
}