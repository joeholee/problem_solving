#include <bits/stdc++.h>
using namespace std;
int N,K,dist[100001],pre[100001];
queue<int> q;
stack<int> st;
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
    st.push(K);
    int tmp=K;
    while(tmp!=N) {
        tmp=pre[tmp];
        st.push(tmp);
    }
    cout << dist[K] << '\n';
    while(!st.empty()) {
        int val=st.top(); st.pop();
        cout << val << ' ';
    }
    return 0;
}