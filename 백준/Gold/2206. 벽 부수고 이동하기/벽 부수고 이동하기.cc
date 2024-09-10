#include <bits/stdc++.h>
using namespace std;
string board[1002];
int dist[1002][1002][2];
int N,M;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for(int i=0; i<N; i++) cin >> board[i];
    dist[0][0][0] = 1;
    dist[0][0][1] = 1;
    queue<tuple<int,int,int> > Q;
    Q.push({0,0,0});
    while(!Q.empty()) {
        auto cur = Q.front();
        Q.pop();
        int x,y,broken;
        tie(x,y,broken) = cur;
        if(x==N-1 && y==M-1) {
            cout << dist[x][y][broken];
            return 0;
        }
        for(int dir=0; dir<4; dir++) {
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx<0||nx>=N||ny<0||ny>=M) continue;
            if(dist[nx][ny][broken]>0) continue;
            if(board[nx][ny]=='0') {
                dist[nx][ny][broken] = dist[x][y][broken]+1;
                Q.push({nx,ny,broken});
            }
            if(board[nx][ny]=='1' && !broken) {
                dist[nx][ny][1] = dist[x][y][broken]+1;
                Q.push({nx,ny,1});
            }
        }
    }
    cout << -1;
}