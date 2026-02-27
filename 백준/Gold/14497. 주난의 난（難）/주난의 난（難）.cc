#include <bits/stdc++.h>
using namespace std;
#define R first
#define C second
#define x1 xx
#define y1 yy
#define x2 xxx
#define y2 yyy
int N,M,x1,y1,x2,y2,dist[301][301];
char a[301][301];
deque<pair<int,int>> dq;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
string s;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    cin >> x1 >> y1 >> x2 >> y2;
    x1--; y1--; x2--; y2--;
    for(int r=0; r<N; r++) {
        cin >> s;
        for(int c=0; c<M; c++) a[r][c]=s[c];
    }
    fill(&dist[0][0],&dist[0][0]+301*301,1e9);
    dist[x1][y1]=1;
    dq.push_back({x1,y1});
    while(!dq.empty()) {
        auto cur = dq.front(); dq.pop_front();
        if(cur.R==x2&&cur.C==y2) break;
        for(int dir=0; dir<4; dir++) {
            int nr=cur.R+dr[dir];
            int nc=cur.C+dc[dir];
            if(nr<0||nr>=N||nc<0||nc>=M) continue;
            if(a[nr][nc]=='1') {
                if(dist[nr][nc]>dist[cur.R][cur.C]+1) {
                    dist[nr][nc]=dist[cur.R][cur.C]+1;
                    dq.push_back({nr,nc});
                }
            }
            else {
                if(dist[nr][nc]>dist[cur.R][cur.C]) {
                    dist[nr][nc]=dist[cur.R][cur.C];
                    dq.push_front({nr,nc});
                }
            }
        }
    }
    cout << dist[x2][y2] << '\n';
    return 0;
}