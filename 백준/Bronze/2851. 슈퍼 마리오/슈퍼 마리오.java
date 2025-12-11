import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] arr = new int[10];
	static int sum;
	
	public static void main(String[] args) throws IOException {
		for(int i=0; i<10; i++) arr[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<10; i++) {
			sum+=arr[i];
			if(sum>100) {
				if(100-(sum-arr[i])<sum-100) {
					sum-=arr[i];
					break;
				}
			}
		}
		bw.write(sum+"");
		bw.close();
		br.close();
	}
}