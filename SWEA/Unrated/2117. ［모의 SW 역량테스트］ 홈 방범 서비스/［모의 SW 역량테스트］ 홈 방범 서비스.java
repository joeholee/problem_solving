import java.util.Scanner;

public class Solution {
    static int N, M;
    static int[][] city;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            city = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) city[i][j] = sc.nextInt();
            }

            int ans = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int K = 1; K <= N + 1; K++) {
                        int homes = countHomes(i, j, K);
                        int cost = K * K + (K - 1) * (K - 1);
                        int profit = homes * M;
                        if (profit >= cost) ans = Math.max(ans,homes);
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }

    public static int countHomes(int x, int y, int K) {
        int count = 0;

        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (Math.abs(x-r) + Math.abs(y-c) < K) count += city[r][c];
            }
        }
        return count;
    }
}
