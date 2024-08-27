import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> st = new Stack<>();
    static int L,H,start,end,tmp,ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        start=1001;
        end=0;
        arr = new int[1001];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            L = Integer.parseInt(input[0]);
            H = Integer.parseInt(input[1]);
            arr[L]=H;
            start=Math.min(start,L);
            end=Math.max(end,L);
        }
        tmp=arr[start];
        for(int i=start+1; i<=end; i++) {
            if(arr[i]<tmp) st.push(i);
            else {
                while(!st.isEmpty()) {
                    int idx = st.pop();
                    arr[idx]=tmp;
                }
                tmp=arr[i];
            }
        }
        st.clear();
        tmp=arr[end];
        for(int i=end-1; i>=start; i--) {
            if(arr[i]<tmp) st.push(i);
            else {
                while(!st.isEmpty()) {
                    int idx = st.pop();
                    arr[idx]=tmp;
                }
                tmp=arr[i];
            }
        }
        for(int i=start; i<=end; i++) ans+=arr[i];
        System.out.println(ans);
    }
}