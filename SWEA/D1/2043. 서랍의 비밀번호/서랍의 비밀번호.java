import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();
		int K = sc.nextInt();
		
		if(P >= K) {
			System.out.println(P-K+1);
		}else { 
			System.out.println(999-K+P+1);
			}
	}

}