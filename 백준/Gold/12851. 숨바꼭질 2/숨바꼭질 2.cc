#include <bits/stdc++.h>
using namespace std;
int N,K,dist[100001],vis[100001];
int main(void) {
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    if(N==K) {
        puts("0");
        puts("1");
        return 0;
    }
    fill(dist, dist+100001, -1);
    dist[N]=0;
    vis[N]=1;
    queue<int> q;
    q.push(N);
    while(!q.empty()) {
        int cur = q.front(); q.pop();
        for(int nxt : {cur-1,cur+1,2*cur}) {
            if(nxt<0||nxt>100000) continue;
            if(dist[nxt]==-1) {
                dist[nxt]=dist[cur]+1;
                vis[nxt]=vis[cur];
                q.push(nxt);
            }
            else if(dist[nxt]==dist[cur]+1) vis[nxt]+=vis[cur];
        }
    }
    cout << dist[K] << '\n' << vis[K] << '\n';
    return 0;
}