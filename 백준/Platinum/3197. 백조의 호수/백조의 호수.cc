#include <bits/stdc++.h>
using namespace std;
int R,C,y,x,ret;
bool can,water[1501][1501],swan[1501][1501];
string S;
char arr[1501][1501];
vector<pair<int,int>> s;
queue<pair<int,int>> wq,nwq,sq,nsq;
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> R >> C;
    for(int r=0; r<R; r++) {
        cin >> S;
        for(int c=0; c<C; c++) {
            arr[r][c]=S[c];
            if(arr[r][c]=='L') {
                s.push_back({r,c});
                wq.push({r,c});
                water[r][c]=true;
            }
            if(arr[r][c]=='.') {
                wq.push({r,c});
                water[r][c]=true;
            }
        }
    }
    sq.push(s[0]);
    swan[s[0].first][s[0].second]=true;
    while(true) {
        while(!sq.empty()) {
            tie(y,x) = sq.front(); sq.pop();
            if(y==s[1].first&&x==s[1].second) {
                can=true;
                break;
            }
            for(int dir=0; dir<4; dir++) {
                int nr=y+dr[dir];
                int nc=x+dc[dir];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(swan[nr][nc]) continue;
                swan[nr][nc]=true;
                if(arr[nr][nc]=='X') nsq.push({nr,nc});
                else sq.push({nr,nc});
            }
        }
        if(can) break;
        while(!wq.empty()) {
            tie(y,x) = wq.front(); wq.pop();
            for(int dir=0; dir<4; dir++) {
                int nr=y+dr[dir];
                int nc=x+dc[dir];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(water[nr][nc]) continue;
                if(arr[nr][nc]=='X') {
                    arr[nr][nc]='.';
                    water[nr][nc]=true;
                    nwq.push({nr,nc});
                }
            }
        }
        sq=nsq;
        wq=nwq;
        while(!nsq.empty()) nsq.pop();
        while(!nwq.empty()) nwq.pop();
        ret++;
    }
    cout << ret << '\n';
    return 0;
}