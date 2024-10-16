import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {

    static class Edge implements Comparable<Edge> {
        int to, time;

        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(time, e.time);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static List<Edge>[] adjList;
    static int[] dist;
    static int[][] firstVisit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjList[i] = new ArrayList<>();
        
        dist = new int[n + 1];
        firstVisit = new int[n + 1][n + 1]; // 각 집하장에서 다른 집하장으로 가는 첫 번째 방문 집하장 배열

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            adjList[from].add(new Edge(to, time));
            adjList[to].add(new Edge(from, time));
        }

        // 각 집하장에서 다익스트라 실행
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append("- "); // 자기 자신으로 가는 경우
                } else {
                    sb.append(firstVisit[i][j]).append(" "); // 첫 번째 방문해야 할 집하장
                }
            }
            sb.append("\n");
            Arrays.fill(dist, Integer.MAX_VALUE); // 다음 다익스트라를 위해 거리 배열 초기화
        }
        
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] vis = new boolean[n + 1];
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        for (int i = 1; i <= n; i++) {
            firstVisit[start][i] = -1; // 초기화, 방문하지 않음을 의미
        }
        firstVisit[start][start] = start; // 자기 자신으로 가는 경우

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.to;

            if (vis[curNode]) continue;
            vis[curNode] = true;

            for (Edge edge : adjList[curNode]) {
                int nextNode = edge.to;
                int nextDist = dist[curNode] + edge.time;

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.add(new Edge(nextNode, nextDist));

                    // 첫 번째 방문해야 할 집하장 갱신
                    if (firstVisit[start][curNode] == start) {
                        firstVisit[start][nextNode] = nextNode; // 출발지에서 바로 연결된 경우
                    } else {
                        firstVisit[start][nextNode] = firstVisit[start][curNode]; // 경로를 따라 업데이트
                    }
                }
            }
        }
    }
}