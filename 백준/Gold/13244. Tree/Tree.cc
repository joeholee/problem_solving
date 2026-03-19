#include <bits/stdc++.h>
using namespace std;
int T,N,M,A,B,vis[1001];
vector<vector<int>> adj;
void dfs(int x) {
    vis[x]=1;
    for(int nxt : adj[x]) {
        if(!vis[nxt]) dfs(nxt);
    }
    return;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> T;
    for(int t=0; t<T; t++) {
        for(int i=0; i<1001; i++) adj.push_back({});
        fill(vis,vis+1001,0);
        int cnt=0;
        cin >> N;
        cin >> M;
        for(int i=0; i<M; i++) {
            cin >> A >> B;
            adj[A].push_back(B);
            adj[B].push_back(A);
        }
        for(int i=1; i<=N; i++) {
            if(!vis[i]) {
                dfs(i);
                cnt++;
            }
        }
        if(M==N-1&&cnt==1) cout << "tree";
        else cout << "graph";
        cout << '\n';
    }
    return 0;
}