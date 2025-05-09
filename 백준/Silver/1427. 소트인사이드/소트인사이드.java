import java.io.*;
import java.util.*;


public class Main {
	static String N;
	static char[] input;
	static Character[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		N = br.readLine();
		input = N.toCharArray();
		arr = new Character[input.length];
		for(int i=0; i<input.length; i++) arr[i] = input[i];
		Arrays.sort(arr, Collections.reverseOrder());
		for(Character c : arr) sb.append(c);
		System.out.println(sb);
	}
}