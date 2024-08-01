import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("\\.");
            if(map.containsKey(input[1])) map.put(input[1],map.get(input[1])+1);
            else map.put(input[1],1);
        }
        List<String> list = new ArrayList<>();
        for(String s : map.keySet()) list.add(s);
        Collections.sort(list);
        for(String s : list) System.out.println(s+" "+map.get(s));
    }
}