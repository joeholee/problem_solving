#include <bits/stdc++.h>
using namespace std;
int N,K,dist[200002],pre[200002];
queue<int> q;
vector<int> v;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    if(N==K) {
        cout << 0 << '\n' << N << '\n';
        return 0;
    }
    fill(dist,dist+100001,-1);
    dist[N]=0;
    q.push(N);
    while(!q.empty()) {
        int cur = q.front(); q.pop();
        for(int nxt : {cur-1, cur+1, 2*cur}) {
            if(nxt<0||nxt>100000) continue;
            if(dist[nxt]!=-1) continue;
            dist[nxt]=dist[cur]+1;
            pre[nxt]=cur;
            q.push(nxt);
        }
    }
    for(int i=K; i!=N; i=pre[i]) v.push_back(i);
    v.push_back(N);
    reverse(v.begin(),v.end());
    cout << dist[K] << '\n';
    for(int i : v) cout << i << ' ';
    return 0;
}