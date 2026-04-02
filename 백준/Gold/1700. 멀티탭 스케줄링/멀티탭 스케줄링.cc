#include <bits/stdc++.h>
using namespace std;
int N,K,ret;
const int INF=101;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    vector<int> v(K);
    int last=-1;
    for(int i=0; i<K; i++) {
        cin >> v[i];
        last=max(last,v[i]);
    }
    vector<queue<int>> pos(last+1);
    for(int i=0; i<K; i++) pos[v[i]].push(i);
    vector<int> next(last+1,INF);
    vector<bool> use(last+1,false);
    int plug=0;
    priority_queue<pair<int,int>> pq;
    for(int i=0; i<K; i++) {
        int cur=v[i];
        pos[cur].pop();
        int curnxt=pos[cur].empty()? INF : pos[cur].front();
        if(use[cur]) {
            next[cur]=curnxt;
            pq.push({curnxt,cur});
            continue;
        }
        if(plug<N) {
            plug++;
            use[cur]=1;
            next[cur]=curnxt;
            pq.push({curnxt,cur});
            continue;
        }
        while(pq.size()) {
            int idx=pq.top().first;
            int dev=pq.top().second;
            if(!use[dev]) {
                pq.pop();
                continue;
            }
            if(next[dev]!=idx) {
                pq.pop();
                continue;
            }
            use[dev]=0;
            pq.pop();
            break;
        }
        use[cur]=1;
        next[cur]=curnxt;
        pq.push({next[cur],cur});
        ret++;
    }
    cout << ret;
    return 0;
}