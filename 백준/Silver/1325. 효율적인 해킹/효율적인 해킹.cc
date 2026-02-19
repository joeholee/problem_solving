#include <bits/stdc++.h>
using namespace std;
int N,M,A,B,mx;
vector<int> ret;
vector<vector<int>> v;
int dfs(int start) {
    vector<int> vis(N+1,0);
    stack<int> st;
    st.push(start);
    vis[start]=1;
    int cnt=1;
    while(!st.empty()) {
        int cur=st.top(); st.pop();
        for(int nxt : v[cur]) {
            if(!vis[nxt]) {
                vis[nxt]=1;
                st.push(nxt);
                cnt++;
            }
        }
    }
    return cnt;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    v.resize(N+1);
    ret.resize(N+1);
    for(int i=0; i<M; i++) {
        cin >> A >> B;
        v[B].push_back(A);
    }
    for(int i=1; i<=N; i++) {
        int cnt=dfs(i);
        if(cnt>mx) {
            mx=cnt;
            ret.clear();
            ret.push_back(i);
        } else if(cnt==mx) ret.push_back(i);
    }
    for(int i : ret) cout << i << ' ';
    return 0;
}