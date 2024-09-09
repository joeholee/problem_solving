import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(B!=1&&A>B) {
			System.out.println("A");
		}else if(A!=1&&B>A) {
			System.out.println("B");
		}else if(A==1&&B==3) {
			System.out.println("A");
		}else {System.out.println("B");}
	
	}

}