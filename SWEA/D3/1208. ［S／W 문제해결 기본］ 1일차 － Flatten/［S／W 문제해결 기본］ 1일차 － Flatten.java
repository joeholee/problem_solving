import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int dump = sc.nextInt();
            int[] box = new int[101];
            int max = 1;
            int min = 100;
            
            // 1.
            for (int i = 0; i < 100; i++) {
                int tmp = sc.nextInt();
                box[tmp]++;
                max = Math.max(max, tmp);
                min = Math.min(min, tmp);
            }
            
            for (int i = 0; i < dump; i++) {
		            // 2. 
                box[min]--;
                box[min + 1]++;

                box[max]--;
                box[max - 1]++;

								// 3. 
                while (box[min] == 0) {
                    min++;
                }

                while (box[max] == 0) {
                    max--;
                }
            }

            System.out.println("#" + tc + " " + (max - min));
        } 
    }
}