#include <bits/stdc++.h>
using namespace std;
int N,M,K,A[51][51],vis[7],ret=5000;
struct Info {
    int r,c,s;
};
vector<Info> v;
vector<int> ord;
void rotate(int r, int c, int s) {
    int tmp[51][51];
    memcpy(tmp,A,sizeof(A));
    for(int i=1; i<=s; i++) {
        int cur=tmp[r-i][c-i];
        for(int y=r-i; y<r+i; y++) tmp[y][c-i]=tmp[y+1][c-i];
        for(int x=c-i; x<c+i; x++) tmp[r+i][x]=tmp[r+i][x+1];
        for(int y=r+i; y>r-i; y--) tmp[y][c+i]=tmp[y-1][c+i];
        for(int x=c+i; x>c-i; x--) tmp[r-i][x]=tmp[r-i][x-1];
        tmp[r-i][c-i+1]=cur;
    }
    memcpy(A,tmp,sizeof(tmp));
}
void dfs() {
    if(ord.size()==K) {
        int tmp[51][51];
        memcpy(tmp,A,sizeof(A));
        for(int i : ord) {
            rotate(v[i].r,v[i].c,v[i].s);
        }
        for(int r=0; r<N; r++) {
            int sum=0;
            for(int c=0; c<M; c++) sum+=A[r][c];
            ret=min(ret,sum);
        }
        memcpy(A,tmp,sizeof(tmp));
        return;
    }
    for(int i=0; i<K; i++) {
        if(vis[i]) continue;
        vis[i]=1;
        ord.push_back(i);
        dfs();
        ord.pop_back();
        vis[i]=0;
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M >> K;
    for(int r=0; r<N; r++) {
        for(int c=0; c<M; c++) cin >> A[r][c];
    }
    for(int i=0; i<K; i++) {
        int r,c,s;
        cin >> r >> c >> s;
        v.push_back({r-1,c-1,s});
    }
    dfs();
    cout << ret;
    return 0;
}