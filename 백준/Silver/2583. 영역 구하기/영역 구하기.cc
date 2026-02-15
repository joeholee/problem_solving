#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[102][102];
bool vis[102][102];
int M,N,K;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> M >> N >> K;
    while(K--) {
        int x1,y1,x2,y2;
        cin >> x1 >> y1 >> x2 >> y2;
        for(int i=y1; i<y2; i++) {
            for(int j=x1; j<x2; j++) board[i][j]=1;
        }
    }
    int cnt=0;
    vector<int> area;
    for(int i=0; i<M; i++) {
        for(int j=0; j<N; j++) {
            if(board[i][j]||vis[i][j]) continue;
            cnt++;
            queue<pair<int,int> > Q;
            vis[i][j]=1;
            Q.push({i,j});
            int tmp=0;
            while(!Q.empty()) {
                auto cur = Q.front();
                Q.pop();
                tmp++;
                for(int dir=0; dir<4; dir++) {
                    int nx = cur.X+dx[dir];
                    int ny = cur.Y+dy[dir];
                    if(nx<0||nx>=M||ny<0||ny>=N) continue;
                    if(board[nx][ny]||vis[nx][ny]) continue;
                    vis[nx][ny]=1;
                    Q.push({nx,ny});
                }
            }
            area.push_back(tmp);
        }
    }
    sort(area.begin(),area.end());
    cout << cnt << '\n';
    for(int i : area) cout << i << ' ';
}