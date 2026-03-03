#include <bits/stdc++.h>
using namespace std;
int N,M,H,a,b,arr[34][14],ret=4;
bool check() {
    for(int st=1; st<=N; st++) {
        int c=st;
        for(int r=1; r<=H; r++) {
            if(arr[r][c]) c++;
            else if(c>1&&arr[r][c-1]) c--;
        }
        if(c!=st) return false;
    }
    return true;
}
bool place(int r, int c) {
    if(arr[r][c]) return false;
    if(c>1&&arr[r][c-1]) return false;
    if(c<N-1&&arr[r][c+1]) return false;
    return true;
}
void dfs(int pos, int cnt) {
    if(cnt>=ret) return;
    if(check()) { ret=min(ret,cnt); return; }
    if(cnt==3) return;
    for(int p=pos; p<(N-1)*H; p++) {
        int r=p/(N-1)+1;
        int c=p%(N-1)+1;
        if(!place(r,c)) continue;
        arr[r][c]=1;
        dfs(p+1,cnt+1);
        arr[r][c]=0;
    }
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M >> H;
    for(int i=0; i<M; i++) {
        cin >> a >> b;
        arr[a][b]=1;
    }
    dfs(0,0);
    cout << (ret==4 ? -1 : ret) << '\n';
    return 0;
}