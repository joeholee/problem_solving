import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][][] memo = new int[21][21][21]; // 메모이제이션 배열 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while (true) {
            str = br.readLine();
            if (str.equals("-1 -1 -1")) break; // 입력이 -1 -1 -1일 경우 종료
            String[] input = str.split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);

            sb.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(") = ")
                    .append(w(A, B, C)).append("\n");
        }

        System.out.print(sb);
    }

    // 메모이제이션을 활용한 w 함수
    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        if (memo[a][b][c] != 0) { // 이미 계산된 값이면 바로 반환
            return memo[a][b][c];
        }

        if (a < b && b < c) {
            memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return memo[a][b][c];
    }
}