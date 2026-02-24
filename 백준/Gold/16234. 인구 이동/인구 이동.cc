#include <bits/stdc++.h>
using namespace std;
#define Y first
#define X second
int N,L,R,sum,ret,A[51][51],vis[51][51];
vector<pair<int,int>> v;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
void dfs(int r, int c, vector<pair<int,int>> &v) {
    for(int dir=0; dir<4; dir++) {
        int nr=r+dr[dir];
        int nc=c+dc[dir];
        if(nr<0||nr>=N||nc<0||nc>=N||vis[nr][nc]) continue;
        int diff=abs(A[r][c]-A[nr][nc]);
        if(diff>=L&&diff<=R) {
            vis[nr][nc]=1;
            v.push_back({nr,nc});
            sum+=A[nr][nc];
            dfs(nr,nc,v);
        }
    }
}
int main() {
    cin >> N >> L >> R;
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) cin >> A[r][c];
    }
    while(true) {
        bool flag=0;
        memset(vis,0,sizeof(vis));
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(!vis[r][c]) {
                    v.clear();
                    vis[r][c]=1;
                    v.push_back({r,c});
                    sum=A[r][c];
                    dfs(r,c,v);
                    if(v.size()==1) continue;
                    for(auto i : v) {
                        A[i.Y][i.X]=sum/v.size();
                        flag=1;
                    }
                }
            }
        }
        if(!flag) break;
        ret++;
    }
    cout << ret << '\n';
    return 0;
}