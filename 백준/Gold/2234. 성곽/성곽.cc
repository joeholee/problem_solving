#include <bits/stdc++.h>
using namespace std;   
const int dr[] = {0,-1,0,1}; 
const int dc[] = {-1,0,1,0}; 
int vis[51][51],a[51][51],comp[2504],N,M,cnt,mx,big;
int dfs(int r, int c, int cnt) {
    if(vis[r][c]) return 0;
    vis[r][c]=cnt;
    int ret=1;
    for(int dir=0; dir<4; dir++) {
        if(!(a[r][c]&(1<<dir))) {
            int nr=r+dr[dir];
            int nc=c+dc[dir];
            ret+=dfs(nr,nc,cnt);
        }
    }
    return ret;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    for(int r=0; r<M; r++) {
        for(int c=0; c<N; c++) cin >> a[r][c];
    }
    for(int r=0; r<M; r++) {
        for(int c=0; c<N; c++) {
            if(!vis[r][c]) {
                cnt++;
                comp[cnt]=dfs(r,c,cnt);
                mx=max(mx,comp[cnt]);
            }
        }
    }
    for(int r=0; r<M; r++) {
        for(int c=0; c<N; c++) {
            if(r+1<M) {
                int a=vis[r+1][c];
                int b=vis[r][c];
                if(a!=b) big=max(big,comp[a]+comp[b]);
            }
            if(c+1<N) {
                int a=vis[r][c+1];
                int b=vis[r][c];
                if(a!=b) big=max(big,comp[a]+comp[b]);
            }
        }
    }
    cout << cnt << '\n' << mx << '\n' << big;
    return 0;
}