import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution // bubble sort
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        bubbleSort(arr);
        System.out.println(arr[N/2]);
	}
    
    static void bubbleSort(int[] arr) {
        for(int i=arr.length-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if(arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
            	}
       		}
    	}
	}
}