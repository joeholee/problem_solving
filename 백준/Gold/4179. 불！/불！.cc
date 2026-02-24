#include <bits/stdc++.h>
using namespace std;
#define Y first
#define X second
int R,C,fist[1001][1001],jist[1001][1001];
string S[1001];
queue<pair<int,int>> q1,q2;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> R >> C;
    memset(fist,-1,sizeof(fist));
    memset(jist,-1,sizeof(jist));
    for(int r=0; r<R; r++) {
        cin >> S[r];
        for(int c=0; c<C; c++) {
            if(S[r][c]=='F') {
                fist[r][c]=0;
                q1.push({r,c});
            }
            if(S[r][c]=='J') {
                jist[r][c]=0;
                q2.push({r,c});
            }
        }
    }
    while(!q1.empty()) {
        auto cur = q1.front(); q1.pop();
        for(int dir=0; dir<4; dir++) {
            int nr=cur.Y+dr[dir];
            int nc=cur.X+dc[dir];
            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(S[nr][nc]=='#'||fist[nr][nc]!=-1) continue;
            fist[nr][nc]=fist[cur.Y][cur.X]+1;
            q1.push({nr,nc});
        }
    }
    while(!q2.empty()) {
        auto cur = q2.front(); q2.pop();
        for(int dir=0; dir<4; dir++) {
            int nr=cur.Y+dr[dir];
            int nc=cur.X+dc[dir];
            if(nr<0||nr>=R||nc<0||nc>=C) {
                cout << jist[cur.Y][cur.X]+1;
                return 0;
            }
            if(S[nr][nc]=='#'||jist[nr][nc]!=-1) continue;
            if(fist[nr][nc]!=-1&&jist[cur.Y][cur.X]+1>=fist[nr][nc]) continue;
            jist[nr][nc]=jist[cur.Y][cur.X]+1;
            q2.push({nr,nc});
        }
    }
    cout << "IMPOSSIBLE";
}