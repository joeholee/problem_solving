#include <bits/stdc++.h>
using namespace std;
int N,num,adj,a[11],vis[11],ret=1e9;
vector<vector<int>> v;
void dfs(int cur, bool group[]) {
    vis[cur]=1;
    for(int nxt : v[cur]) {
        if(vis[nxt]) continue;
        if(!group[nxt]) continue;
        dfs(nxt,group);
    }
}
bool check(vector<int> &V) {
    bool group[11]={0};
    memset(vis,0,sizeof(vis));
    for(int i : V) group[i]=1;
    int cnt=0;
    dfs(V[0],group);
    for(int i : V) {
        if(vis[i]) cnt++;
    }
    return cnt==V.size();
}
void calc(vector<int> &A, vector<int> &B) {
    int sumA=0, sumB=0;
    for(int i : A) sumA+=a[i];
    for(int i : B) sumB+=a[i];
    ret=min(ret,abs(sumA-sumB));
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int i=0; i<=N; i++) v.push_back({});
    for(int i=1; i<=N; i++) cin >> a[i];
    for(int i=1; i<=N; i++) {
        cin >> num;
        for(int j=0; j<num; j++) {
            cin >> adj;
            v[i].push_back(adj);
        }
    }
    for(int i=1; i<(1<<N)-1; i++) {
        vector<int> A,B;
        for(int j=1; j<=N; j++) {
            if(i&(1<<(j-1))) A.push_back(j);
            else B.push_back(j);
        }
        if(check(A)&&check(B)) calc(A,B);
    }
    cout << ((ret==1e9) ? -1 : ret) << '\n';
}