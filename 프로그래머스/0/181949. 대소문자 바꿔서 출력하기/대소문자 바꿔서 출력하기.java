import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String ans = "";
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        for(char c : str.toCharArray()) {
            if(Character.isUpperCase(c)) ans += Character.toLowerCase(c);
            else ans += Character.toUpperCase(c);
        }
        System.out.println(ans);
    }
}