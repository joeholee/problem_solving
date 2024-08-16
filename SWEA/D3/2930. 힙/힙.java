import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    static int[] heap = new int[100001];
    static int heapSize;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.setLength(0);
            heapSize=0;
            System.out.print("#"+test_case+" ");
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                if(cmd.equals("1")) {
                    int data = Integer.parseInt(st.nextToken());
                    heapPush(data);
                }
                else heapPop();
            }
            System.out.println(sb);
        }
    }
     
    static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
     
    static void heapPush(int data) {
        heap[++heapSize]=data;
        int ch = heapSize;
        int p = ch/2;
        while(ch>1 && heap[ch]>heap[p]) {
            swap(ch,p);
            ch = p;
            p = ch/2;
        }
    }
     
    static void heapPop() {
        int popData = heap[1];
        if(heapSize==0) {
            sb.append(-1+" ");
            return;
        }
        sb.append(popData+" ");
        heap[1]=heap[heapSize--];
        int p = 1;
        int ch = 2*p;
        if(ch+1<=heapSize && heap[ch]<heap[ch+1]) ch++;
        while(ch<=heapSize && heap[ch]>heap[p]) {
            swap(ch,p);
            p = ch;
            ch = 2*p;
            if(ch+1<=heapSize && heap[ch]<heap[ch+1]) ch++;
        }
    }
}