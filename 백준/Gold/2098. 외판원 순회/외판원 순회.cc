#include <bits/stdc++.h>
using namespace std;
int N,W[16][16],dp[16][1<<16];
const int INF = 987654321;
int tsp(int cur, int vis) {
    if(vis==(1<<N)-1) {
        return W[cur][0] ? W[cur][0] : INF;
    }
    int &ret = dp[cur][vis];
    if(ret!=-1) return ret;
    ret=INF;
    for(int i=0; i<N; i++) {
        if(vis&(1<<i)) continue;
        if(!W[cur][i]) continue;
        ret=min(ret,tsp(i,vis|(1<<i))+W[cur][i]);
    }
    return ret;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) cin >> W[r][c];
    }
    fill(&dp[0][0],&dp[15][1<<16],-1);
    cout << tsp(0,1);
    return 0;
}