public class Solution {
	public static void main(String[] args) {
		
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if(r==c) {
					System.out.print("#");
				}else {System.out.print("+");}
			}
			System.out.println();
		}
	}
}