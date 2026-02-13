#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[52][52];
bool vis[52][52];
int T,M,N,K,X,Y;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    while(T--) {
        cin >> M >> N >> K;
        for(int i=0; i<N; i++) {
            fill(board[i],board[i]+M,0);
            fill(vis[i],vis[i]+M,0);
        }
        for(int i=0; i<K; i++) {
            cin >> X >> Y;
            board[Y][X]=1;
        }
        int ans=0;
        queue<pair<int,int> > Q;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(vis[i][j]||board[i][j]==0) continue;
                ans++;
                vis[i][j]=1;
                Q.push({i,j});
                while(!Q.empty()) {
                    auto cur = Q.front();
                    Q.pop();
                    for(int dir=0; dir<4; dir++) {
                        int nx = cur.X+dx[dir];
                        int ny = cur.Y+dy[dir];
                        if(nx<0||nx>=N||ny<0||ny>=M) continue;
                        if(vis[nx][ny]||board[nx][ny]==0) continue;
                        vis[nx][ny]=1;
                        Q.push({nx,ny});
                    }
                }
            }
        }
        cout << ans << '\n';
    }
}