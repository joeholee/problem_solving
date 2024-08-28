import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int sz=1000000;
	static int[] A = new int[sz];
	public static void main(String args[]) throws Exception
	{
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<1000000; i++) A[i]=Integer.parseInt(st.nextToken());
		quickSort(0,sz-1);
		System.out.println(A[500000]);
	}

	static void quickSort(int left, int right) {
		if(left<right) {
			int pivot = partition(left,right);
			quickSort(left,pivot-1);
			quickSort(pivot+1,right);
		}
	}
	
	static int partition(int left, int right) {
		int pivot = A[left];
		int L = left+1;
		int R = right;
		while(L<=R) {
			while(A[L]<=pivot) L++;
			while(A[R]>pivot) R--;
			if(L<R) {
				int tmp = A[L];
				A[L] = A[R];
				A[R] = tmp;
			}
		}
		int tmp = A[left];
		A[left] = A[R];
		A[R] = tmp;
		
		return R;
	}
}