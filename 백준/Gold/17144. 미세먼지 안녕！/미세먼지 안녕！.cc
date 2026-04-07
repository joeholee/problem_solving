#include <bits/stdc++.h>
using namespace std;
int R,C,T,top,bot,ret,A[51][51];
const int dr[] = {-1,0,1,0};
const int dc[] = {0,1,0,-1};
void spread() {
    int tmp[51][51] = {0,};
    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {
            if(A[r][c]>0) {
                int amt=A[r][c]/5;
                int cnt=0;
                for(int dir=0; dir<4; dir++) {
                    int nr=r+dr[dir];
                    int nc=c+dc[dir];
                    if(nr<0||nr>=R||nc<0||nc>=C) continue;
                    if(A[nr][nc]==-1) continue;
                    cnt++;
                    tmp[nr][nc]+=amt;
                }
                tmp[r][c]+=A[r][c]-cnt*amt;
            }
        }
    }
    tmp[top][0]=-1; tmp[bot][0]=-1;
    memcpy(A,tmp,sizeof(tmp));
}
void air() {
    for(int r=top; r>0; r--) A[r][0]=A[r-1][0];
    for(int c=0; c<C-1; c++) A[0][c]=A[0][c+1];
    for(int r=0; r<top; r++) A[r][C-1]=A[r+1][C-1];
    for(int c=C-1; c>0; c--) A[top][c]=A[top][c-1];
    A[top][0]=-1;
    A[top][1]=0;
    for(int r=bot; r<R-1; r++) A[r][0]=A[r+1][0];
    for(int c=0; c<C-1; c++) A[R-1][c]=A[R-1][c+1];
    for(int r=R-1; r>bot; r--) A[r][C-1]=A[r-1][C-1];
    for(int c=C-1; c>0; c--) A[bot][c]=A[bot][c-1];
    A[bot][0]=-1;
    A[bot][1]=0;
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> R >> C >> T;
    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) {
            cin >> A[r][c];
            if(A[r][c]==-1) {
                if(!top) top=r;
                else bot=r;
            }
        }
    }
    while(T-->0) {
        spread();
        air();
    }
    for(int r=0; r<R; r++) {
        for(int c=0; c<C; c++) ret+=A[r][c];
    }
    cout << ret+2;
    return 0;
}