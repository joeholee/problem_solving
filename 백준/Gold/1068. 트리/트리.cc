#include <bits/stdc++.h>
using namespace std;
int N,node,root,ret,p[51];
vector<vector<int>> tree;
void dfs(int cur) {
    if(cur==node) return;
    int cnt=0;
    for(auto nxt : tree[cur]) {
        if(nxt==node) continue;
        cnt++;
        dfs(nxt);
    }
    if(!cnt) ret++;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) tree.push_back({});
    for(int i=0; i<N; i++) {
        cin >> p[i];
        if(p[i]==-1) root=i;
        else tree[p[i]].push_back(i);
    }
    cin >> node;
    if(node==root) {
        cout << 0;
        return 0;
    }
    dfs(root);
    cout << ret << '\n';
    return 0;
}