import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String ans = "";
		for(int i=0; i<a; i++) ans += "#";
		System.out.println(ans);
	}

}