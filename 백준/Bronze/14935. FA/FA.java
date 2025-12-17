import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String x;
	
	public static void main(String[] args) throws IOException {
		x = br.readLine();
		bw.write("FA");
		bw.close();
		br.close();
	}
}