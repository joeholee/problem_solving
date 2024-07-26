import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 2;
        while(N>0) {
            ans = ans*2 - 1;
            N--;
        }
        System.out.println(ans*ans);
    }
}