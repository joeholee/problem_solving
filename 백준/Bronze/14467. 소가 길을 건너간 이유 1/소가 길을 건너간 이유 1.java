import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,String> cows = new HashMap<>();
        int ans=0;
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            if(!cows.containsKey(input[0])) cows.put(input[0],input[1]);
            else {
                if(!cows.get(input[0]).equals(input[1])) {
                    ans++;
                    cows.put(input[0],input[1]);
                }
            }
        }
        System.out.print(ans);
    }
}