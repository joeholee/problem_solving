import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int div,den,tmp=1;
	public static void main(String[] args) {
		int X = sc.nextInt();
		while(X>0) {
			if(tmp%2==0) {
				div=0;
				den=tmp+1;
			}
			else {
				div=tmp+1;
				den=0;
			}
			for(int i=1; i<=tmp; i++) {
				if(tmp==1) div=den=1;
				else {
					if(tmp%2==0) {
						div++;
						den--;
					}
					else {
						div--;
						den++;
					}
				}
				X--;
				if(X==0) break;
			}
			tmp++;
		}
		System.out.print(div+"/"+den);
	}
}