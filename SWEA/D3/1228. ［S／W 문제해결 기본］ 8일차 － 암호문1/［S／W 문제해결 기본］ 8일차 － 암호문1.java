import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Node {
    int data;
    Node next;
}
 
class SLL {
    Node head;
    int size;
     
    public SLL() {head = new Node();}
     
    void addData(int x, int y, int[] data) {
        Node cur = head;
        for(int i=0; i<x; i++) cur = cur.next;
        for(int k=0; k<y; k++) {
            Node newNode = new Node();
            newNode.data = data[k];
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next;
            size++;
        }
    }
}
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sb.setLength(0);
            int N = Integer.parseInt(br.readLine());
            SLL list = new SLL();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] init_data = new int[N];
            for(int i=0; i<N; i++) init_data[i] = Integer.parseInt(st.nextToken());
            list.addData(0, N, init_data);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                if(st.nextToken().charAt(0)=='I') {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    int[] data = new int[y];
                    for(int k=0; k<y; k++) data[k] = Integer.parseInt(st.nextToken());
                    list.addData(x,y,data);
                }
            }
            System.out.print("#"+test_case+" ");
            Node cur = list.head;
            for(int i=0; i<10; i++) {
                cur = cur.next;
                sb.append(cur.data+" ");
            }
            System.out.println(sb);
        }
    }
}