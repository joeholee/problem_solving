import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int width,height,num,maxW,maxH;
	static List<Integer> wList,hList;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(br.readLine());
		wList = new ArrayList<>();
		hList = new ArrayList<>();
		wList.add(width);
		hList.add(height);
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) hList.add(Integer.parseInt(st.nextToken()));
			else wList.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(wList);
		Collections.sort(hList);
		int prevW=0,prevH=0;
		for(int i : hList) {
			maxH = Math.max(maxH, i-prevH);
			prevH = i;
		}
		for(int i : wList) {
			maxW = Math.max(maxW, i-prevW);
			prevW = i;
		}
		bw.write(maxW*maxH+"");
		bw.close();
		br.close();
	}
}