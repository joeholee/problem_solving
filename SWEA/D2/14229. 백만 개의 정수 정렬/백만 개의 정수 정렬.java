import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int sz=1000000;
    static int[] A = new int[sz];
    static int[] tmp = new int[sz];
    public static void main(String args[]) throws Exception
    {
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<1000000; i++) A[i]=Integer.parseInt(st.nextToken());
        mergeSort(0,sz-1);
        System.out.println(A[500000]);
    }
     
    static void mergeSort(int left, int right) {
        if(left<right) {
            int mid = left/2+right/2;
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            merge(left,mid,right);
        }
    }
     
    static void merge(int left, int mid, int right) {
        int L = left;
        int R = mid+1;
        int idx = left;
        while(L<=mid && R<=right) {
            if(A[L]<=A[R]) tmp[idx++]=A[L++];
            else tmp[idx++]=A[R++];
        }
        if(L<=mid) {
            for(int i=L; i<=mid; i++) tmp[idx++]=A[i];
        }
        else {
            for(int i=R; i<=right; i++) tmp[idx++]=A[i];
        }
        for(int i=left; i<=right; i++) A[i]=tmp[i];
    }
}