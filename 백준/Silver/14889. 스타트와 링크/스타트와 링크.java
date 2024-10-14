import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static Set<Integer> num;
    static int leftSum;
    static int rightSum;
    static int minSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        num = new HashSet<Integer>();
        minSum = Integer.MAX_VALUE;
        combination(N, N/2,  new int[N/2], 0, 0);
        System.out.println(minSum / 2);

    }
    public static void combination(int n, int k, int[] newArr, int idx, int start) {
        if (idx == k) {
            for (int i = 0; i < n; i++) {
                num.add(i);
            }

            leftSum = 0;
            rightSum = 0;

            for (int i = 0; i < k; i++) {
                if (num.contains(newArr[i])) {
                    num.remove(newArr[i]);
                }
                for (int j = 0; j < k; j++) {
                    if (newArr[i] != newArr[j]) {
                        leftSum += arr[newArr[i]][newArr[j]];
                        leftSum += arr[newArr[j]][newArr[i]];
                    }
                }
            }

            for (Integer num1 : num) {
                for (Integer num2 : num) {
                    if (num1 != num2) {
                        rightSum += arr[num1][num2];
                        rightSum += arr[num2][num1];
                    }
                }
            }

            minSum = Math.min(minSum, Math.abs(leftSum - rightSum));


            return;
        }


        for (int i = start; i < n; i++) {
            newArr[idx] = i;
            combination(n, k, newArr, idx + 1, i + 1);
        }
    }
}