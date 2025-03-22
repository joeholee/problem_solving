
public class Main {
	static boolean[] self = new boolean[10001];
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		for(int i=1; i<=10000; i++) {
			int n = d(i);
			if(n<=10000) self[n] = true;
		}
		for(int i=1; i<=10000; i++) {
			if(!self[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	public static int d(int n) {
		int sum = n;
		while(n!=0) {
			sum += n%10;
			n/=10;
		}
		return sum;
	}
}