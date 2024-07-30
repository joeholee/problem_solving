import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution // selection sort
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
        selectionSort(arr);
        System.out.println(arr[N/2]);
	}
    
    static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            int minIdx=i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j]<arr[minIdx]) minIdx=j;
            }
            int tmp=arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=tmp;
        }
    }
}