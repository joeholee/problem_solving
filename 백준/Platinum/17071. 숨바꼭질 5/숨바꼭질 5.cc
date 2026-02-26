#include <bits/stdc++.h>
using namespace std;
const int MAX=500000;
int vis[2][MAX+1],N,K,ok,t=1;
queue<int> q;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    if(N==K) {
        cout << 0 << '\n';
        return 0;
    }
    vis[0][N]=1;
    q.push(N);
    while(!q.empty()) {
        K+=t;
        if(K>MAX) break;
        if(vis[t%2][K]) {
            ok=1;
            break;
        }
        int qs=q.size();
        for(int i=0; i<qs; i++) {
            int cur=q.front(); q.pop();
            for(int nxt : {cur+1,cur-1,2*cur}) {
                if(nxt<0||nxt>MAX) continue;
                if(vis[t%2][nxt]) continue;
                vis[t%2][nxt]=vis[(t+1)%2][cur]+1;
                if(nxt==K) {
                    ok=1;
                    break;
                }
                q.push(nxt);
            }
            if(ok) break;
        }
        if(ok) break;
        t++;
    }
    cout << (ok ? t : -1) << '\n';
    return 0;
}