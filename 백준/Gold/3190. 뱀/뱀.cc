#include <bits/stdc++.h>
using namespace std;
int N,K,L,ret,hr,hc,dir,arr[101][101];
const int dr[] = {0,1,0,-1};
const int dc[] = {1,0,-1,0};
struct Info {
    int X; char C;
    Info(int X, char C) {
        this->X=X;
        this->C=C;
    }
};
queue<Info> q;
deque<pair<int,int>> dq;
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    for(int i=0; i<K; i++) {
        int r,c;
        cin >> r >> c;
        arr[r-1][c-1]=1;
    }
    cin >> L;
    for(int i=0; i<L; i++) {
        int X; char C;
        cin >> X >> C;
        q.push(Info(X,C));
    }
    dq.push_back({0,0});
    arr[0][0]=-1;
    while(true) {
        ret++;
        int nr=hr+dr[dir];
        int nc=hc+dc[dir];
        if(nr<0||nr>=N||nc<0||nc>=N) break;
        if(arr[nr][nc]==-1) break;
        if(!arr[nr][nc]) {
            auto tail = dq.front();
            dq.pop_front();
            arr[tail.first][tail.second]=0;
        }
        arr[nr][nc]=-1;
        dq.push_back({nr,nc});
        hr=nr;
        hc=nc;
        if(q.size()) {
            auto cur=q.front();
            if(ret==cur.X) {
                if(cur.C=='L') {
                    dir=(dir+3)%4;
                } else dir=(dir+1)%4;
                q.pop();
            }
        }
    }
    cout << ret;
    return 0;
}