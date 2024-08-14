import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Node {
    char data;
    Node left;
    Node right;
     
    Node() {}
}
 
class Solution
{
    static Node[] tree;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            tree = new Node[N+1];
            for(int i=1; i<=N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx=0;
                int l_idx=0;
                int r_idx=0;
                char data = 0;
                while(st.hasMoreTokens()) {
                    idx = Integer.parseInt(st.nextToken());
                    data = st.nextToken().charAt(0);
                    if(!st.hasMoreTokens()) break;
                    l_idx = Integer.parseInt(st.nextToken());
                    if(!st.hasMoreTokens()) break;
                    r_idx = Integer.parseInt(st.nextToken());
                }
                Node newNode = new Node();
                newNode.data=data;
                newNode.left=tree[l_idx];
                newNode.right=tree[r_idx];
                tree[idx]=newNode;
            }
            System.out.print("#"+test_case+" ");
            inorder(1);
            System.out.println();
        }
    }
     
    static void inorder(int idx) {
        if(idx>=tree.length || tree[idx].data==0) return;
        inorder(idx*2);
        System.out.print(tree[idx].data);
        inorder(idx*2+1);
    }
}